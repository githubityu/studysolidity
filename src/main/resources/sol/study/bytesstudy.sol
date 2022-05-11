// SPDX-License-Identifier: MIT
pragma solidity ^0.8;

contract BytesStudy{
    bytes1 a2 = '1';
    bytes5 hh = 0xffffffffff;
    bytes2 b = '11';
    bytes3 c = 0xff;
    bytes32 d = '0123456789012345678901234';
 
     function test() public view returns (bytes4, bytes1, bytes1, bytes1, bytes1,bytes1){
      bytes4 a = 0x001122FF;
      return (a, a[0], a[1], a[2], a[3],a2);
    }
    function getBytes(bytes1  num) internal pure returns(bytes1){
            return num;
    }
}