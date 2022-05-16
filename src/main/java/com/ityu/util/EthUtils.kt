package com.ityu.util


import org.web3j.abi.DefaultFunctionEncoder
import org.web3j.abi.TypeEncoder
import org.web3j.abi.datatypes.DynamicArray
import org.web3j.abi.datatypes.generated.Uint256
import org.web3j.crypto.Credentials
import org.web3j.crypto.RawTransaction
import org.web3j.crypto.TransactionEncoder
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService
import org.web3j.utils.Convert
import org.web3j.utils.Numeric
import java.math.BigDecimal
import java.math.BigInteger


fun getWeb3j(): Web3j {
    //https://kovan.infura.io/v3/212a3359b2bb4684b9b99c9a8a7a771f
    //https://ropsten.infura.io/v3/212a3359b2bb4684b9b99c9a8a7a771f
    //https://rpc-mumbai.matic.today
    val service = HttpService(
        "https://ropsten.infura.io/v3/212a3359b2bb4684b9b99c9a8a7a771f", getOkHttpClient2()
    )
    return Web3j.build(service)
}

inline fun <reified T> getJavaClass(): Class<T> {
    return T::class.java
}

fun getCre(priKey: String): Credentials {
    return Credentials.create(priKey)
}

fun getUint256(number: String): Uint256 {
    return Uint256(BigInteger(number))
}

fun toDynamicArray(array: MutableList<Uint256>): DynamicArray<Uint256> {
    return DynamicArray(Uint256::class.java, array.toList())
}


fun getTx(){
    val ethGetTransactionByHash =
        getWeb3j().ethGetTransactionByHash("0x29e2023bfc9b86a0bdef9ebebcdf1ce714b1762adc6334b1d0ac5f52475b5099 ").send()

   // val nonce = ethGetTransactionByHash.transaction.get().nonce


    print("nonce:${ethGetTransactionByHash}")
}

fun replaceNonce(privateKey: String, nonce: String, to: String): String {
    val gasPrice = getSimpleGasPrice(getWeb3j().ethGasPrice().send().gasPrice)
    val gasLimit = BigInteger("21000")
    val credentials = Credentials.create(privateKey)
    val rawTransaction = RawTransaction.createEtherTransaction(
        BigInteger(nonce),
        gasPrice,
        gasLimit,
        to,
        BigInteger.ZERO
    )
    val signMessage = TransactionEncoder.signMessage(rawTransaction, credentials)
    val hexValue = Numeric.toHexString(signMessage)
    return getWeb3j().ethSendRawTransaction(hexValue)
        .send().transactionHash ?: ""
}

//优化价格
fun getSimpleGasPrice(price: BigInteger): BigInteger {
    val fromWei = Convert.fromWei(price.toBigDecimal(), Convert.Unit.GWEI)
    val mul = when {
        fromWei > BigDecimal(80) -> {
            "1.2"
        }
        fromWei > BigDecimal(60) -> {
            "1.32"
        }
        fromWei > BigDecimal(40) -> {
            "1.4"
        }
        fromWei > BigDecimal(20) -> {
            "1.6"
        }
        else -> {
            "2"
        }
    }
    return price.multiply(BigDecimal(mul).toBigInteger())
}

