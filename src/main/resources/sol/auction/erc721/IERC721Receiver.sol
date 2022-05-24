// SPDX-License-Identifier: MIT
pragma solidity ^0.8;
interface IERC721Receiver {
  function onERC721Received(
    address _operator,
    address _from,
    uint256 _tokenId,
    bytes memory  _userData
  ) external returns (bytes4);
}