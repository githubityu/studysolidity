pragma solidity ^0.8.0;

//方便代理中使用同样顺序的属性变量
//因为delegatecall改变的代理合约中变量的值而不是业务合约的
//call改变的是业务合约中的变量，由于业务合约会改变，因此需要把变量数据存在代理合约中
//变量存储是通过插槽按照定义顺序存储，0开始，每个插槽保存32个字节（byte）大小的数据
contract VarStore {

}
