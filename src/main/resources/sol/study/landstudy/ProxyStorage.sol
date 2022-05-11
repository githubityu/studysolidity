pragma solidity ^0.8.0;

contract ProxyStorage {

    /**
     * Current contract to which we are proxing
     */
    address public currentContract;
    address public proxyOwner;
}