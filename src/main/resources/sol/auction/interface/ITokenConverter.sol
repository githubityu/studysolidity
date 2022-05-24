// SPDX-License-Identifier: MIT
pragma solidity ^0.8;
import "./IERC20.sol";

interface ITokenConverter {    


    /**
    * @dev Makes a simple ERC20 -> ERC20 token trade
    * @param _srcToken - IERC20 token
    * @param _destToken - IERC20 token 
    * @param _srcAmount - uint256 amount to be converted
    * @param _destAmount - uint256 amount to get after conversion
    * @return uint256 for the change. 0 if there is no change
    */
    function convert(
        IERC20 _srcToken,
        IERC20 _destToken,
        uint256 _srcAmount,
        uint256 _destAmount
        ) external returns (uint256);

    /**
    * @dev Get exchange rate and slippage rate. 
    * Note that these returned values are in 18 decimals regardless of the destination token's decimals.
    * @param _srcToken - IERC20 token
    * @param _destToken - IERC20 token 
    * @param _srcAmount - uint256 amount to be converted
    * @return expectedRate of the expected rate
    * @return slippageRate of the slippage rate
    */
    function getExpectedRate(IERC20 _srcToken, IERC20 _destToken, uint256 _srcAmount) 
          external view returns(uint256 expectedRate, uint256 slippageRate);
}
