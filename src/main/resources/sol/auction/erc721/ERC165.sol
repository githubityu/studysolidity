// SPDX-License-Identifier: MIT
pragma solidity ^0.8;
interface ERC165 {
  function supportsInterface(bytes4 interfaceID) external view returns (bool);
}