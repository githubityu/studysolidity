// SPDX-License-Identifier: MIT

pragma solidity ^0.8.0;


import "./StorageSlot.sol";
import "./Address.sol";

contract ERC1967Proxy{


    bytes32 internal constant _IMPLEMENTATION_SLOT = 0x360894a13ba1a3210667c828492db98dca3e2076cc3735a920a3ca505d382bbc;

    using StorageSlot for bytes32;


    function getSolt(string calldata name) public pure returns (bytes32){
        return bytes32(uint256(keccak256(abi.encodePacked(name))) - 1);
    }



    function _setImplementation(address newImplementation) public   {
         StorageSlot.getAddressSlot(_IMPLEMENTATION_SLOT).value = newImplementation;
    }

     function _getImplementation() internal view returns (address) {
        return StorageSlot.getAddressSlot(_IMPLEMENTATION_SLOT).value;
    }



    function studyLibrary() public  view returns (bool){

      //未定义的情况下可以直接使用相当于静态方法  
      address a1 =   StorageSlot.getAddressSlot(_IMPLEMENTATION_SLOT).value;
     //在定义了using xxx for yyy
      address a2 =  _IMPLEMENTATION_SLOT.getAddressSlot().value;
      return  a1==a2;
    
    }


}