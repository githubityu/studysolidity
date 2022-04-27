package com.ityu.soliditystudy

import com.ityu.Ens
import com.ityu.EstateRegistry
import com.ityu.LANDRegistry
import com.ityu.MANAToken
import com.ityu.util.getCre
import com.ityu.util.getSimpleGasPrice
import com.ityu.util.getWeb3j
import com.ityu.util.testGetMatic
import org.web3j.abi.datatypes.Address
import org.web3j.abi.datatypes.Bool
import org.web3j.abi.datatypes.Utf8String
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
//    val web3j = getWeb3j()
//    val cre = getCre("186b16258a979cf597edebadbaf2e6d5ac65e5ab4197d5cfc7ff4c301ca9ab13")
//
//    val load = MANAToken.load(
//        "0x9b591Bf99aE5818AA19fE171099d048039D3Eced",
//        web3j,
//        ReadonlyTransactionManager(web3j, "0x630959E5aE57D1165c29B5aDC2F77C2bB8B730a0"),
//        DefaultGasProvider()
//    )
//    var balance = load.balanceOf(Address("0x630959E5aE57D1165c29B5aDC2F77C2bB8B730a0")).send()
//
//    println("balanc=${balance.value}")

    //DynamicArray(Uint256::class.java,)
//    val xPoint = mutableListOf(
//        getUint256("0"),
//        getUint256("86400"),
//    )
//    val yPoint = mutableListOf(
//        getUint256("200000000000000000000000"),
//        getUint256("100000000000000000000000"),
//    )
//    val send = LANDAuction.deploy(
//        web3j,
//        cre,
//        DefaultGasProvider(),
//        toDynamicArray(xPoint),
//        toDynamicArray(yPoint),
//        getUint256("1650594040"),
//        getUint256("20"),
//        getUint256("20000000000"),
//        Address("0x9b591Bf99aE5818AA19fE171099d048039D3Eced"),
//        Address("0x9890086091dbD825e6300b0065Aea7ba88ac7d6c"),
//        Address("0xbFCF36c90540753f913aD625Ed9612a78cBabA80"),
//
//        ).send()
//    println(send.contractAddress)
    //testHttpClient()
    //StaticGasProvider(DefaultGasProvider.GAS_PRICE, BigInteger("3000000"))
    //val gasPrice = getSimpleGasPrice(getWeb3j().ethGasPrice().send().gasPrice)
    //val send = Ens.deploy(web3j, cre, StaticGasProvider(getSimpleGasPrice(gasPrice), BigInteger("900000"))).send()
    // val send = Ens.load(web3j, cre, DefaultGasProvider()).send()
   // val address = send.contractAddress
   // print(address)
    // replaceNonce("e7cca1246f31d9aa849dc05882ba07eac8f4243b5d0af26456cb2b057c126387","56","0x630959E5aE57D1165c29B5aDC2F77C2bB8B730a0")

//  val address  =  Erc20Token2.deploy(
//        web3j,
//        cre,
//      StaticGasProvider(DefaultGasProvider.GAS_PRICE, BigInteger("210000")),
//        "人民币",
//        "rmb",
//        BigInteger("18"),
//        Convert.toWei("10000000", Convert.Unit.ETHER).toBigInteger(),
//        "0x630959E5aE57D1165c29B5aDC2F77C2bB8B730a0"
//    ).send();

    // getTx()


//    val contractAddress =
//        EstateRegistry.load("0x403725e11F9521418070C295d61F715970990458", web3j, cre, StaticGasProvider(getSimpleGasPrice(gasPrice), BigInteger("900000")))
//            .mint(
//                Address("0x630959E5aE57D1165c29B5aDC2F77C2bB8B730a0"), Utf8String.DEFAULT
//            ).send().contractAddress
//    print(contractAddress)
//   val datas =  mutableListOf(
//        "0x630959E5aE57D1165c29B5aDC2F77C2bB8B730a0",
//        "0x0e2457A0B68023FBD0516Aa4c7FDC2e356934Fff",
//        "0xaFE35D020625FD018E5FcE57F31E75c81457EA55",
//        "0x1742525e081385C24F793319166DddFdB9602BE9",
//        "0xf9d751780C1686b05c75bB72e7DcE4505C441C53"
//    )
//    while (true){
//        Thread.sleep(30000)
//        testGetMatic(datas[(0..4).random()])
//    }
   val number =  Convert.toWei("10000000", Convert.Unit.ETHER).toBigInteger()
   val number2 =  Convert.toWei("100", Convert.Unit.ETHER).toBigInteger()
   val n1 = Numeric.encodeQuantity(number)
   val n2 = Numeric.encodeQuantity(number2)
   val n3 = Numeric.encodeQuantity(BigInteger.ONE)
   val n4 = Numeric.encodeQuantity(BigInteger.ZERO)
   val n5 = Numeric.encodeQuantity(BigInteger.TEN)

   println(n1)
   println(n2)
   println(n3)
   println(n4)
   println(n5)



}