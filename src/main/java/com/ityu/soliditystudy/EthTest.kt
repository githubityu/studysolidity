package com.ityu.soliditystudy

import com.ityu.*
import com.ityu.util.*
import org.web3j.abi.datatypes.Address
import org.web3j.abi.datatypes.Bool
import org.web3j.abi.datatypes.DynamicArray
import org.web3j.abi.datatypes.Utf8String
import org.web3j.abi.datatypes.generated.Int256
import org.web3j.abi.datatypes.generated.Uint256
import org.web3j.tx.FastRawTransactionManager
import org.web3j.tx.ReadonlyTransactionManager
import org.web3j.tx.gas.DefaultGasProvider
import org.web3j.tx.gas.StaticGasProvider
import org.web3j.utils.Convert
import org.web3j.utils.Numeric
import java.math.BigInteger


fun main() {

    //e7cca1246f31d9aa849dc05882ba07eac8f4243b5d0af26456cb2b057c126387
    //b05d79f5f9605a2f8156475856677fa5feef8d1c6a4105842984e4a60955e6df
    //c917844d5f8ab4ca595e626ce218c5275eec689f2b2072fe793ea53ee88b25ce
    //186b16258a979cf597edebadbaf2e6d5ac65e5ab4197d5cfc7ff4c301ca9ab13
    val web3j = getWeb3j()
//    CatalystApp.load("0xfc03B569e381145fC3e3bDE5EbCCa272378475c8",web3j,ReadonlyTransactionManager(web3j,"0x630959E5aE57D1165c29B5aDC2F77C2bB8B730a0"),DefaultGasProvider())
   var cre = getCre("e7cca1246f31d9aa849dc05882ba07eac8f4243b5d0af26456cb2b057c126387")
//    testGraphql()
    //https://rpc-mumbai.matic.today/
   // val  txMananger =  FastRawTransactionManager(web3j, getCre("e7cca1246f31d9aa849dc05882ba07eac8f4243b5d0af26456cb2b057c126387"), 80001)

   // val send = ContractDeploy.deploy(web3j,txMananger, DefaultGasProvider()).send()
   // print(send.contractAddress)
//    while (true){
//        Thread.sleep(5000)
//        testGetRop("")
//    }
//    var str = ""
//    ( -150..150).forEach {
//        str = str.plus("$it,")
//    }
//    print(str)
    /**
     * ,
    ,


" "  ,
     */
     val strList = mutableListOf(
        "128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150"
    )

    val list = strList[0].split(",").map {
        Int256(BigInteger("$it"))
    }
    val x = DynamicArray(list)

     val land = LANDRegistry.load("0x2aC2b63dd88Ea1e5431f87Eac7C1c0F3400bc291", web3j,cre,getSimpleGasPrice(web3j.ethGasPrice().send().gasPrice),BigInteger("8000000"))
    val  hash =  land.assignMultipleParcels(x,x,Address("0xaFE35D020625FD018E5FcE57F31E75c81457EA55")).send().transactionHash
    print(hash)
}
