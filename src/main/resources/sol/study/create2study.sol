pragma solidity ^0.8.0;

contract create2study {
    function createVesting(address _implementation, bytes32 _salt, bytes memory _data) public virtual returns (address addr) {
        bytes32 salt = keccak256(abi.encodePacked(_salt, msg.sender));

        // solium-disable-next-line security/no-inline-assembly
        bytes memory slotcode = abi.encodePacked(
            hex"3d602d80600a3d3981f3363d3d373d3d3d363d73",
            _implementation,
            hex"5af43d82803e903d91602b57fd5bf3"
        );

        assembly {
            addr := create2(0, add(slotcode, 0x20), mload(slotcode), salt)
        }
        require(addr != address(0), "MinimalProxyFactory#createVesting: CREATION_FAILED");

        emit VestingCreated(addr, _salt);

        if (_data.length > 0) {
            (bool success,) = addr.call(_data);
            require(success, "MinimalProxyFactory#createVesting: CALL_FAILED");
        }
    }

    function deployProxyWithNonce(
        //构造方法参数
        address _singleton,
        //bytecode
        bytes memory initializer,
        //盐
        uint256 saltNonce
    ) internal returns (GnosisSafeProxy proxy) {
        // If the initializer changes the proxy address should change too. Hashing the initializer data is cheaper than just concatinating it
        bytes32 salt = keccak256(abi.encodePacked(keccak256(initializer), saltNonce));
        bytes memory deploymentData = abi.encodePacked(type(GnosisSafeProxy).creationCode, uint256(uint160(_singleton)));
        // solhint-disable-next-line no-inline-assembly
        assembly {
            proxy := create2(0x0, add(0x20, deploymentData), mload(deploymentData), salt)
        }
        require(address(proxy) != address(0), "Create2 call failed");
    }

    // Creates a wrapped asset using AssetMeta
    function _createWrapped(BridgeStructs.AssetMeta memory meta, uint64 sequence) internal returns (address token) {
        // initialize the TokenImplementation
        bytes memory initialisationArgs = abi.encodeWithSelector(
            TokenImplementation.initialize.selector,
            bytes32ToString(meta.name),
            bytes32ToString(meta.symbol),
            meta.decimals,
            sequence,

            address(this),

            meta.tokenChain,
            meta.tokenAddress
        );

        // initialize the BeaconProxy
        bytes memory constructorArgs = abi.encode(address(this), initialisationArgs);

        // deployment code
        bytes memory bytecode = abi.encodePacked(type(BridgeToken).creationCode, constructorArgs);

        bytes32 salt = keccak256(abi.encodePacked(meta.tokenChain, meta.tokenAddress));

        assembly {
            token := create2(0, add(bytecode, 0x20), mload(bytecode), salt)

            if iszero(extcodesize(token)) {
                revert(0, 0)
            }
        }

        setWrappedAsset(meta.tokenChain, meta.tokenAddress, token);
    }



}
