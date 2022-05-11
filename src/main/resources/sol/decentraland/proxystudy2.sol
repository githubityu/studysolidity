pragma solidity ^0.8;
import "hardhat/console.sol";
import "@openzeppelin/contracts/utils/math/SafeMath.sol";

contract B{
    uint public num;
    uint public value;
    
    function donate(uint _num) payable public returns(uint){
        num = _num;
        value = SafeMath.add(value, msg.value);
        console.log("in B donate:");
        return value;
    }
}

//A中通过abi调用B中的方法
contract A{
    uint public num;
    uint public value;
    address public impl;
     function doFunction(string memory func,uint _num) payable public returns(bool,bytes memory){
         (bool success, bytes memory data) = impl.delegatecall(
             abi.encodeWithSignature(func, _num)
         );
          console.log("in A donate:");
          return (success,data);
    }
    function setB(address _impl) external{
        impl = _impl;
    }


    //接受eth
    receive() external payable {  }
    fallback () external payable {
        (bool success, bytes memory res) = impl.delegatecall(msg.data);
         console.log("in A fallback:");
        assembly {
            //分配空闲区域指针
            let ptr := mload(0x40)
            //将返回值从返回缓冲去copy到指针所指位置
            returndatacopy(ptr, 0, returndatasize())

            //根据是否调用成功决定是返回数据还是直接revert整个函数
            switch success
            case 0 { revert(ptr, returndatasize()) }
            default { return(ptr, returndatasize()) }
        }
    }
}
