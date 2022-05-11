// SPDX-License-Identifier: MIT
pragma solidity ^0.8;

/**
    calldataload(p) 位置 p 的调用数据（32 字节）
    sload(p) =storage[p]
    mload(p)= mem[p...(p + 32))
    mstore(p, v)=mem[p...(p + 32)) := v
    calldataload
    call
    0x40 空闲内存指针 
    0x60 初始化空的动态数组
    keccak("masterCopy()") 获取方法的16进制
    type(GnosisSafeProxy).runtimeCode
    returndatasize
*/
//导入要使用的合约，而不是全部导入
//studyHuiBian-matic测试-0x4a59420Ac441B6F332dE0F93146d533d0b978346
//StorageAccessible-0xCfe23AF143Eb88a9FF09d5567Ef6f33bDA99E9FD
import {yuString} from "./yuLibs.sol";

//import "hardhat/console.sol";
contract studyHuiBian{
    //使用 一个参数的直接xx.xxx()
    //多个参数的就是yuString.strConcat(x,y)
     using yuString for string;
     uint a = 0;
     uint b;
     address public testAddress;

    function setTestAddress(address _testAddress) external{
        testAddress = _testAddress;
    }

    //测试代理方法
    function doFunction(address impl,string memory signature, uint _num) public{
        (bool success, bytes memory data) = impl.delegatecall(abi.encodeWithSignature(signature, _num));

    }


    function myLog(string memory name)  view public{
         //console.log(yuString.strConcat("in studyHuiBian->",name));
     }

    function testZMCL()  public  view returns(uint _z) {
        myLog("testZMCL");
        assembly { 
            mstore(0x80, add(mload(0x80), 3)) 
            _z := mload(0x80)
            }
    }

    function clear()  view public returns(uint){
         myLog("clear");
        //要清空有符号类型，你可以使用 signextend 操作码 
        uint d = getSum(1,2);
        assembly{
            d:= and(d, 0xffffffff)
        }
        return d;
    }


    //汇编里面用全局属性必须x.slot 把值存在这个内存上面
    //全局变量赋值sstore
    //sload 从内存中读取值
     function updateB(uint x)  public {
          myLog("updateB");
              assembly {
                  let c := mul(x, add(2, a.slot))
                  sstore(b.slot,c)               
              }
     }
       function updateA(uint x)  public {
          myLog("updateA");
              assembly {
                  let c := add(x, a.slot)
                  sstore(a.slot,c)               
              }
     }
     function getAB() public  view returns (uint,uint ){
             myLog("getAB");
            return (a,b);
     }
      function getSum(uint _a,uint _b) public view  returns (uint _c){
            myLog("getSum");
          assembly{
                _c := add(_a,_b)
          }
     }

}

contract StorageAccessible {
    /**
     * @dev Reads `length` bytes of storage in the currents contract
     * @param offset - the offset in the current contract's storage in words to start reading from
     * @param length - the number of words (32 bytes) of data to read
     * @return the bytes that were read.
     */
    function getStorageAt(uint256 offset, uint256 length) public view returns (bytes memory) {
        bytes memory result = new bytes(length * 32);
        for (uint256 index = 0; index < length; index++) {
            // solhint-disable-next-line no-inline-assembly
            assembly {
                let word := sload(add(offset, index))
                mstore(add(add(result, 0x20), mul(index, 0x20)), word)
            }
        }
        return result;
    }

    /**
     * @dev Performs a delegetecall on a targetContract in the context of self.
     * Internally reverts execution to avoid side effects (making it static).
     *
     * This method reverts with data equal to `abi.encode(bool(success), bytes(response))`.
     * Specifically, the `returndata` after a call to this method will be:
     * `success:bool || response.length:uint256 || response:bytes`.
     *
     * @param targetContract Address of the contract containing the code to execute.
     * @param calldataPayload Calldata that should be sent to the target contract (encoded method name and arguments).
     */
    function simulateAndRevert(address targetContract, bytes memory calldataPayload) external {
        // solhint-disable-next-line no-inline-assembly
        assembly {
            let success := delegatecall(gas(), targetContract, add(calldataPayload, 0x20), mload(calldataPayload), 0, 0)

            mstore(0x00, success)
            mstore(0x20, returndatasize())
            returndatacopy(0x40, 0, returndatasize())
            //revert(0, add(returndatasize(), 0x40))
        }
    }
}