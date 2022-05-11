pragma solidity ^0.8.0;
import "@openzeppelin/contracts/utils/Strings.sol";
import {yuString} from "./yuLibs.sol";
contract Sha256Test {
    using Strings for uint256;
    using yuString for string;
    uint256 time = 123;
    event hashResult(bytes32);
    event hashResultt(bytes,bytes);
    event hashResult2(bytes32,bytes32);
    event hashResult3(bytes32,bytes32,bytes32);
    event hashResult4(bytes32,bytes32,bytes32,bytes32);
    event hashResult5(bytes32,bytes32,bytes32,bytes32,bytes32);
    event hashResult7(bytes32,bytes32,bytes32,bytes32,bytes32,bytes32,bytes32);
    function calcSha256(string memory input) public {
        uint256 a = 123;
        string  memory dt   = input.strConcat(Strings.toString(a));
        emit hashResult(sha256(abi.encodePacked(dt)));
    }

      function testEncodePacked(string memory input) public {
         bytes  memory a1 =  abi.encodePacked(input);
         bytes  memory a11 =  abi.encode(input,input,123);
         bytes  memory a2 =  abi.encodePacked(bytes(input),bytes(input),bytes(input));
         bytes32   a3 =  keccak256("a");
         bytes32   a4 =  keccak256(a11);
         emit hashResultt(a1,a2);
    }

    function test() pure public returns (bytes32){
        return keccak256("aragonOS.appStorage.kernel");
    }
}
