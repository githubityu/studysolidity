// SPDX-License-Identifier: MIT

pragma solidity >=0.8.0;
import "./TransparentUpgradeableProxy.sol";

//用户信息
contract MyAppStorage {

 struct User{
     uint age;
     uint sex;
     bool isMember;
 }
  mapping (address => User) public users;
  bool public isOpen;
  string public appName;
}
contract OwnableStorage is MyAppStorage {
  address public owner;
   constructor()  {
    owner = msg.sender;
  }

  event OwnerUpdate(address _prevOwner, address _newOwner);

  modifier onlyOwner {
    require(msg.sender == owner,"only owner");
    _;
  }

  function transferOwnership(address _newOwner) public onlyOwner {
    require(_newOwner != owner, "Cannot transfer to yourself");
    owner = _newOwner;
  }

}

contract MyAppProxy is TransparentUpgradeableProxy,OwnableStorage{
    constructor(address logic, address admin, bytes memory data) payable TransparentUpgradeableProxy(logic, admin, data) {}
}