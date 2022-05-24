// SPDX-License-Identifier: MIT
pragma solidity ^0.8;
contract AssetRegistryStorage {

  string public _name;
  string public _symbol;
  string public _description;

  /**
   * Stores the total count of assets managed by this registry
   */
  uint256 public _count;

  /**
   * Stores an array of assets owned by a given account
   */
  mapping(address => uint256[]) public _assetsOf;

  /**
   * Stores the current holder of an asset
   */
  mapping(uint256 => address) public _holderOf;

  /**
   * Stores the index of an asset in the `_assetsOf` array of its holder
   */
  mapping(uint256 => uint256) public _indexOfAsset;

  /**
   * Stores the data associated with an asset
   */
  mapping(uint256 => string) public _assetData;

  /**
   * For a given account, for a given opperator, store whether that operator is
   * allowed to transfer and modify assets on behalf of them.
   */
  mapping(address => mapping(address => bool)) public _operators;

  /**
   * Approval array
   */
  mapping(uint256 => address) public _approval;
}
