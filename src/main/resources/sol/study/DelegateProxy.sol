// SPDX-License-Identifier: MIT
pragma solidity ^0.8;
import "hardhat/console.sol";
contract DelegateProxy {
  /**
   * @dev Performs a delegatecall and returns whatever the delegatecall returned (entire context execution will return!)
   * @param targetContract Destination address to perform the delegatecall
   * @param calldataPayload Calldata for the delegatecall
   */
  function delegatedFwd(address targetContract, bytes memory calldataPayload) internal {
    require(isContract(targetContract));
    assembly {
      let result := delegatecall(gas(), targetContract, add(calldataPayload, 0x20), mload(calldataPayload), 0, 0)
      let size := returndatasize()

      let ptr := mload(0x40)
      returndatacopy(ptr, 0, size)

      // revert instead of invalid() bc if the underlying call failed with invalid() it already wasted gas.
      // if the call returned error data, forward it
      switch result case 0 { revert(ptr, size) }
      default { return(ptr, size) }
    }
  }

  function isContract(address _target) view internal returns (bool) {
    uint256 size;
    assembly { size := extcodesize(_target) }
    return size > 0;
  }
}