// SPDX-License-Identifier: MIT
pragma solidity ^0.8;

contract studyHuiBian{

     uint a = 0;
     uint b;

    //汇编里面用全局属性必须x.slot
    //全局变量赋值sstore
     function testCzf(uint number) public {
              assembly {
                  let c := mul(number, add(2, a.slot))
                  sstore(b.slot,c)               
              }
     }

     function getB() public view returns (uint ){
            return b;
     }

}