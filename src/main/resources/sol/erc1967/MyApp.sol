// SPDX-License-Identifier: MIT

pragma solidity >=0.8.0;

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

interface IMyApp{
 event RegisterUser(
    address indexed _caller,
    address indexed _deployer
  );
  event eOpen(
    bool indexed rIsOpen
  );
  event logName(string name);

   function updateOpen(bool _isOpen) external;
}

contract MyApp is OwnableStorage,IMyApp{


  function initialize() external {
    appName = "AppTest";
  }

  modifier onlyOpen {
    require(isOpen,"only open");
    _;
  }
  // 测试阶段用public，正式环境用external
  function registerUser(address beneficiary) public onlyOpen{
    require(beneficiary != address(0), "invalid address");
    require(users[beneficiary].isMember == false, "address is already register");
    User storage user =  users[beneficiary];
    user.isMember = true;
    emit RegisterUser(msg.sender, beneficiary);
  } 
    
  //用的onlyOwner就是proxy中的
  function updateOpen(bool _isOpen) override public onlyOwner{
         isOpen = _isOpen;
         emit eOpen(isOpen);
 }


}
