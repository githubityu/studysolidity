// SPDX-License-Identifier: MIT
pragma solidity ^0.8;

import "./ERC721Base.sol";

interface IERC721Enumerable{

  /**
   * @notice Enumerate active tokens
   * @dev Throws if `index` >= `totalSupply()`, otherwise SHALL NOT throw.
   * @param index A counter less than `totalSupply()`
   * @return The identifier for the `index`th asset, (sort order not
   *  specified)
   */
  // TODO (eordano): Not implemented
  // function tokenByIndex(uint256 index) public view returns (uint256 _assetId);

  /**
   * @notice Count of owners which own at least one asset
   *  Must not throw.
   * @return A count of the number of owners which own asset
   */
  // TODO (eordano): Not implemented
  // function countOfOwners() public view returns (uint256 _count);

  /**
   * @notice Enumerate owners
   * @dev Throws if `index` >= `countOfOwners()`, otherwise must not throw.
   * @param index A counter less than `countOfOwners()`
   * @return The address of the `index`th owner (sort order not specified)
   */
  // TODO (eordano): Not implemented
  // function ownerByIndex(uint256 index) public view returns (address owner);

  /**
   * @notice Get all tokens of a given address
   * @dev This is not intended to be used on-chain
   * @param owner address of the owner to query
   * @return a list of all assetIds of a user
   */
  function tokensOf(address owner) external  view returns (uint256[] memory );

  /**
   * @notice Enumerate tokens assigned to an owner
   * @dev Throws if `index` >= `balanceOf(owner)` or if
   *  `owner` is the zero address, representing invalid assets.
   *  Otherwise this must not throw.
   * @param owner An address where we are interested in assets owned by them
   * @param index A counter less than `balanceOf(owner)`
   * @return tokenId The identifier for the `index`th asset assigned to `owner`,
   *   (sort order not specified)
   */
  function tokenOfOwnerByIndex(
    address owner, uint256 index
  ) external  view returns (uint256 tokenId);
}

// File: erc821/contracts/ERC721Enumerable.sol

contract ERC721Enumerable is  IERC721Enumerable,AssetRegistryStorage {

  /**
   * @notice Get all tokens of a given address
   * @dev This is not intended to be used on-chain
   * @param owner address of the owner to query
   * @return a list of all assetIds of a user
   */
  function tokensOf(address owner) external override view returns (uint256[] memory) {
    return _assetsOf[owner];
  }

  /**
   * @notice Enumerate tokens assigned to an owner
   * @dev Throws if `index` >= `balanceOf(owner)` or if
   *  `owner` is the zero address, representing invalid assets.
   *  Otherwise this must not throw.
   * @param owner An address where we are interested in assets owned by them
   * @param index A counter less than `balanceOf(owner)`
   * @return assetId The identifier for the `index`th asset assigned to `owner`,
   *   (sort order not specified)
   */
  function tokenOfOwnerByIndex(
    address owner, uint256 index
  )
    external override
    view
    returns (uint256 assetId)
  {
    require(index < _assetsOf[owner].length);
    require(index < (1<<127));
    return _assetsOf[owner][index];
  }

}

// File: erc821/contracts/IERC721Metadata.sol

interface IERC721Metadata {

  /**
   * @notice A descriptive name for a collection of NFTs in this contract
   */
  function name() external view returns (string memory);

  /**
   * @notice An abbreviated name for NFTs in this contract
   */
  function symbol() external view returns (string memory);

  /**
   * @notice A description of what this DAR is used for
   */
  function description() external view returns (string memory);

  /**
   * Stores arbitrary info about a token
   */
  function tokenMetadata(uint256 assetId) external view returns (string memory);
}

// File: erc821/contracts/ERC721Metadata.sol

contract ERC721Metadata is  AssetRegistryStorage, IERC721Metadata {
  function name() external override  view returns (string memory) {
    return _name;
  }
  function symbol() external override view returns (string memory) {
    return _symbol;
  }
  function description() external override view returns (string memory) {
    return _description;
  }
  function tokenMetadata(uint256 assetId) external override view returns (string memory) {
    return _assetData[assetId];
  }
  function _update(uint256 assetId, string memory data) internal {
    _assetData[assetId] = data;
  }
}

// File: erc821/contracts/FullAssetRegistry.sol

contract FullAssetRegistry is ERC721Enumerable, ERC721Metadata {
  constructor()  {
  }

  /**
   * @dev Method to check if an asset identified by the given id exists under this DAR.
   * @return uint256 the assetId
   */
  function exists(uint256 assetId) external view returns (bool) {
    return _exists(assetId);
  }
  function _exists(uint256 assetId) internal view returns (bool) {
    return _holderOf[assetId] != address(0);
  }

  function decimals() external pure returns (uint256) {
    return 0;
  }
}