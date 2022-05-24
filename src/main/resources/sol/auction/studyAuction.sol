// SPDX-License-Identifier: MIT
pragma solidity ^0.8;

import "./interface/IERC20.sol";
contract ProxyStorage {

  /**
   * Current contract to which we are proxing
   */
  address public currentContract;
  address public proxyOwner;
}

contract OwnableStorage {

  address public owner;
   event OwnerUpdate(address _prevOwner, address _newOwner);

  constructor() internal {
    owner = msg.sender;
  }
    modifier onlyOwner {
    assert(msg.sender == owner);
    _;
  }

  function transferOwnership(address _newOwner) public onlyOwner {
    require(_newOwner != owner, "Cannot transfer to yourself");
    owner = _newOwner;
  }

}


contract XXXStorage{
  uint256 constant clearLow = 0xffffffffffffffffffffffffffffffff00000000000000000000000000000000;
  uint256 constant clearHigh = 0x00000000000000000000000000000000ffffffffffffffffffffffffffffffff;
  uint256 constant factor = 0x100000000000000000000000000000000;

  mapping (address => bool) internal _deprecated_authorizedDeploy;

  mapping (uint256 => address) public updateOperator;

  IEstateRegistry public estateRegistry;

  mapping (address => bool) public authorizedDeploy;

  mapping(address => mapping(address => bool)) public updateManager;

  // Land balance minime token
  IMiniMeToken public landBalance;

  // Registered balance accounts
  mapping(address => bool) public registeredBalance;

}

contract Storage is ProxyStorage, OwnableStorage, XXXStorage {
}


contract StudyAuction{
function assignMultipleParcels(int[] x, int[] y, address beneficiary) external  {
    for (uint i = 0; i < x.length; i++) {
      _generate(_encodeTokenId(x[i], y[i]), beneficiary);
      _updateXXXBalance(address(0), beneficiary);
    }
  }

 
  function _generate(uint256 assetId, address beneficiary) internal {
    require(_holderOf[assetId] == 0);

    _addAssetTo(beneficiary, assetId);

    emit Transfer(0, beneficiary, assetId);
  }


    function _addAssetTo(address to, uint256 assetId) internal {
    _holderOf[assetId] = to;

    uint256 length = _balanceOf(to);

    _assetsOf[to].push(assetId);

    _indexOfAsset[assetId] = length;

    _count = _count.add(1);
  }

    function _encodeTokenId(int x, int y) internal pure returns (uint result) {
    require(
      -1000000 < x && x < 1000000 && -1000000 < y && y < 1000000,
      "The coordinates should be inside bounds"
    );
    return _unsafeEncodeTokenId(x, y);
  }

    function _unsafeEncodeTokenId(int x, int y) internal pure returns (uint) {
        return ((uint(x) * factor) & clearLow) | (uint(y) & clearHigh);
    }

  function decodeTokenId(uint value) external pure returns (int, int) {
    return _decodeTokenId(value);
  }

  function _decodeTokenId(uint value) internal pure returns (int x, int y) {
    (x, y) = _unsafeDecodeTokenId(value);
    require(
      -1000000 < x && x < 1000000 && -1000000 < y && y < 1000000,
      "The coordinates should be inside bounds"
    );
  }

  function _unsafeDecodeTokenId(uint value) internal pure returns (int x, int y) {
    x = expandNegative128BitCast((value & clearLow) >> 128);
    y = expandNegative128BitCast(value & clearHigh);
  }

    function expandNegative128BitCast(uint value) internal pure returns (int) {
    if (value & (1<<127) != 0) {
      return int(value | clearLow);
    }
    return int(value);
  }
}
