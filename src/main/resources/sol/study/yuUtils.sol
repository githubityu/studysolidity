// SPDX-License-Identifier: MIT
pragma solidity ^0.8;
library VectorSum {
    // 因为目前的优化器在访问数组时无法移除边界检查，
    // 所以这个函数的执行效率比较低。
    function sumSolidity(uint[]  memory _data) public pure returns (uint o_sum) {
        for (uint i = 0; i < _data.length; ++i)
            o_sum += _data[i];
    }

    // 我们知道我们只能在数组范围内访问数组元素，所以我们可以在内联汇编中不做边界检查。
    // 由于 ABI 编码中数组数据的第一个字（32 字节）的位置保存的是数组长度，
    // 所以我们在访问数组元素时需要加入 0x20 作为偏移量。
    function sumAsm(uint[] memory _data) public pure returns (uint o_sum) {
        for (uint i = 0; i < _data.length; ++i) {
            assembly {
                o_sum := add(o_sum, mload(add(add(_data, 0x20), mul(i, 0x20))))
            }
        }
    }

    // 和上面一样，但在内联汇编内完成整个代码。
    function sumPureAsm(uint[] memory _data) public pure returns (uint o_sum) {
        assembly {
           // 取得数组长度（前 32 字节）
           let len := mload(_data)

           // 略过长度字段。
           //
           // 保持临时变量以便它可以在原地增加。
           //
           // 注意：对 _data 数值的增加将导致 _data 在这个汇编语句块之后不再可用。
           //      因为无法再基于 _data 来解析后续的数组数据。
           let data := add(_data, 0x20)

           // 迭代到数组数据结束
           for
               { let end := add(data, mul(len, 0x20)) }
               lt(data, end)
               { data := add(data, 0x20) }
           {
               o_sum := add(o_sum, mload(data))
           }
        }
    }
}


library GetCode {
    function at(address _addr) public view returns (bytes memory o_code) {
        assembly {
            // 获取代码大小，这需要汇编语言
            let size := extcodesize(_addr)
            // 分配输出字节数组 – 这也可以不用汇编语言来实现
            // 通过使用 o_code = new bytes（size）
            o_code := mload(0x40)
            // 包括补位在内新的“memory end”
            mstore(0x40, add(o_code, and(add(add(size, 0x20), 0x1f), not(0x1f))))
            // 把长度保存到内存中
            mstore(o_code, size)
            // 实际获取代码，这需要汇编语言
            extcodecopy(_addr, add(o_code, 0x20), 0, size)
        }
    }
}