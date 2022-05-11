// SPDX-License-Identifier: MIT
pragma solidity ^0.8;

//重写父类方法必须写上virtual虚拟 接口默认都是virtual
contract A{
    uint public aFild = 100;
    function testA() public virtual pure returns  (string memory) {
        return 'A-testA';
    }
    function testInternal() internal pure returns (bytes memory) {
        return 'internal-testA';
    }
}

contract B is A{
    uint public bFild = 100;
    function testB() public pure returns (bytes memory) {
        return 'testB';
    }
    function testA() override public pure returns (string memory) {
        return 'B-testA';
    }
    //如果需要向合约转币就需要添加两个方法
    fallback() payable external{

    }
    receive() payable external{
    }
}