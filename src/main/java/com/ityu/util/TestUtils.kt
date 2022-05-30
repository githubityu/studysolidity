package com.ityu.util

import com.ityu.*
import com.ityu.soliditystudy.TestJava
import com.ityu.util.JsonUtil.getObjectNode
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.apache.commons.io.FileUtils
import org.web3j.abi.datatypes.Address
import org.web3j.abi.datatypes.DynamicArray
import org.web3j.abi.datatypes.generated.Int256
import org.web3j.abi.datatypes.generated.Uint256
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.tx.gas.StaticGasProvider
import java.io.File
import java.io.IOException
import java.math.BigInteger


fun testHttpClient() {
    val toRequestBody =
        "0x0e2457a0b68023fbd0516aa4c7fdc2e356934fff".toRequestBody("application/json; charset=utf-8".toMediaType())
    val post = Request.Builder().url("https://faucet.metamask.io/v0/request").post(toRequestBody).build()
    val client = getOkHttpClient().newCall(post).execute()
    //0x0000000000000000000000000000000000000000
    println(client.body?.string() ?: "====")
}


fun testGetMatic(address: String) {
    val apply = getObjectNode().apply {
        put("network", "mumbai")
        put("address", address)
        put("token", "maticToken")
    }
    val toRequestBody = apply.toString().toRequestBody("application/json; charset=utf-8".toMediaType())
    val post = Request.Builder().url("https://api.faucet.matic.network/transferTokens").post(toRequestBody).build()
    val client = getOkHttpClient().newCall(post).execute()
    //0x0000000000000000000000000000000000000000
    println(client.body?.string() ?: "====")
}


fun testGetRop(address: String) {
    try {
        val toRequestBody = "0x6f9301Df6DF8Ad6B18De4CbA665B9fc09f377219".toRequestBody("application/rawdata".toMediaType())
        val post = Request.Builder().addHeader("X-Forwarded-For", getIp()).url("https://faucet.metamask.io/v0/request").post(toRequestBody).build()
        val client = getOkHttpClient().newCall(post).execute()
        //0x0000000000000000000000000000000000000000
        println(client.body?.string() ?: "====")
    } catch (e: Exception) {
    }
}

fun testGetRinkeby(address: String) {
    val apply = getObjectNode().apply {
        put("networkInfo", getObjectNode().apply {
            put("network", "rinkeby")
            put("chain", "eth")
        })
        put("toAddress", "0x6f9301Df6DF8Ad6B18De4CbA665B9fc09f377219")
        put("clientRequestId", "alch_faucet_storage_v1_27faa453-1c6d-4b91-b0a0-0695a5a36335")
        put("alchemyUserId", "234288")
        put("reCAPTCHAValue", "03AGdBq26a78gtN8blZxtYA4cPHOFFjutypH-CMHazNo8gsJeps6CLP7bKO4b19LfquQIllo3VZomfgTkofOojloe3DekrEjyCCKV7r8KVZIeeXijn8NiaLEenZPuDA93sv_6x97_WCLW7ZkWa48jylZaYmfNcmj0qBKNSqKZGrigNhdkFqi2qSBzfZpl1zx4mCDx12iS-N1-jBcjzI2AL0S2YjPoXujH0G6zSvuiOkQDoDUmGZeY0KxJy5B0Pi3bZFPNOwQv_kUjbCxCRG0bmTdQFmUmYfjZIzmCypyonliAXG5QstD1p26AE-nwi3jDmSUVj5ITOzKqWXNKDghHdhZpoxCKPWlv-nXHY4knJ03kF3DU4_IR5yUcE3XBCZJnBq0AKZak3oFZMDjbrW6U7d9BUZRfGynrXtmmcNJf1sAMMVGIT0NAeQCQ9vVsAfIr6Wu78sFU0PV2imsPPxUD1VUGVbxuknmKwdLZoH89_IZqOdEk6gTNSZAq6UFv-C010CjDWgLaGDYtWofPbUpTNaQXhMPKmUUV_Jwi9N6K_AxPv-DpANx4svGGL2g8dUjmmHr-U6vs3FmyKZP-OM_q1ctlXl2c6kLgwMAhZzL6jyT-XzN_PiOQjDvdLl4BOB3jB8jXu5gQhmQSWpsaFWJyOn2cyyxgO0nttcjIZU0RZkFHjITcFE2BFWlC_wgP-4NOM129vpArbw4tnHN4nb4mnuAKDGc85ZfSCXDBPZgUmR6SPZ2PctzjIi0x6RnnTQyFcYUvOi9rWjksSK9pEy4L4K6fEP9kQUX_lFVlvuO-ogXsLbr7JO8THmcIbTjIaqSw8aOZ3YRgbAZ1DY7GKtEp5dpnewUNRb_CpkorX6UaHzIoy5sQOpzTtEoV6y2QQB3cPKdmz42GyDx8_qxGRth9irriKgqLx-g3oCkkvGPbr28I9m0kc_U4bctOL6nhE91Gn5wWCMm8HqlxEuMLvnkFOR7xzVae8I1rU2PrLC7HFBCrR_TntZfNyzKU2VKEdkKwH1zEfZYA3NONbZ3c85pfro35XvMEOL2yyIAvxvtV2EM0YfD71AjcipWYTkKbI2YOE3U4Be2Uj3rsGxnNTcx8qmHTkZZFbtYtCunX29QBlSxCxq5-fHPPWJS5I-WyPTGKa8iSCh2v6CtahjZNzZsWV-gp1N1mb9rMpD-gq_frkqPVxAfmM2WRBAyG3Isw_Pr6hgadXTu62Nwpz8CP8aOvkGdplkyDj2qcVBY_rdp3VYIIDcMp0QkAjO1eQGgLC5q_wb8AUfhmMYHS2wXJQakpQ3dZArlhQCHFfdFaZsp_je_zxi-BR9MRyT1vyLktDZTTk34zEHQmeWJAt275aT-xNeYVWUUmhHlRynlgrzb7TFAo4wYNy6tjLHkLgLVBcysl39qJxEqAeoOfD8ktvGSU9pjML1AOHXnO9EA2UGixxVVZsQekX6AKhCcFoGuaJ9xhtQWudX3swRSVQKRrlaE4-un6QFEbFfW-ABr4LCPFaMuRQBSGsD0nlprTE2REo7WUhzwHakeJBxdKSiWPR1mAysQLP3pnbHIXxQuC5X58V3QtT-iVmnD8Aaj4")
    }

    val toRequestBody = apply.toString().toRequestBody("application/json; charset=utf-8".toMediaType())
    val post = Request.Builder().url("https://rinkebyfaucet.com/api/v1/transfer").post(toRequestBody).build()
    val client = getOkHttpClient().newCall(post).execute()
    //0x0000000000000000000000000000000000000000
    println(client.body?.string() ?: "====")
}


fun testGraphql() {
    val apply = getObjectNode().apply {
        put(
            "query", """query{
  uses{
    id
  }
}"""
        )
    }

    val apply2 = getObjectNode().apply {
        put(
            "query", """mutation{
  createUser(userInput:{
    email:"test@test4",
    password:"testest3"
  }){
    id
    password
  }
}"""
        )
    }


    val apply3 = getObjectNode().apply {
        put(
            "query", """mutation cU(${'$'}email:String!,${'$'}password:String!){
  createUser(userInput:{
    email:${'$'}email,
    password:${'$'}password
  }){
    id
    password
    email
  }
}""").put("variables", getObjectNode().put("email","3@3.com").put("password","99999"))
    }

    val toRequestBody = apply3.toString().toRequestBody("application/json; charset=utf-8".toMediaType())
    val post = Request.Builder().url("http://localhost:8081/graphql").post(toRequestBody).build()
    val client = getOkHttpClient().newCall(post).execute()
    //0x0000000000000000000000000000000000000000
    println(client.body?.string() ?: "====")
}


fun testLand(web3j: Web3j,cre:Credentials){
    val xy =  getXy1("50")
    //val xy =  getXy2("-12")
    //val xy = getXy3("2","-12")
    val land = LANDRegistry.load("0x2aC2b63dd88Ea1e5431f87Eac7C1c0F3400bc291", web3j,cre,getSimpleGasPrice(web3j.ethGasPrice().send().gasPrice),BigInteger("8000000"))
    val  hash =  land.assignMultipleParcels(xy.first,xy.second, Address("0xaFE35D020625FD018E5FcE57F31E75c81457EA55")).send().transactionHash
    print(hash)
}

fun testKernel(web3j: Web3j,cre:Credentials){
    val kernel = Kernel.load("0x5164027dda9b44917e035337bfb46db68b9a7b1d", web3j,cre,getSimpleGasPrice(web3j.ethGasPrice().send().gasPrice),BigInteger("8000000"))

    val address =   kernel.acl().send().typeAsString
    print(address)
}


fun nameAvTest(web3j: Web3j,cre:Credentials){
    val avatarName = AvatarNameRegistry.load("0xbe49e7635a1C3FF7F91981aD1AB6dDB6c34ea3E7", web3j,cre,getSimpleGasPrice(web3j.ethGasPrice().send().gasPrice),BigInteger("8000000"))
    //val manaToken = MANAToken.load("0x9b591Bf99aE5818AA19fE171099d048039D3Eced", web3j,cre,getSimpleGasPrice(web3j.ethGasPrice().send().gasPrice),BigInteger("8000000"))

    val hash =  avatarName.user("0x630959E5aE57D1165c29B5aDC2F77C2bB8B730a0").send()

    //val hash =  manaToken.approve(Address("0xbe49e7635a1C3FF7F91981aD1AB6dDB6c34ea3E7"), Uint256(BigInteger("10000000000000000000000000"))).send().transactionHash

    print(hash.component1().plus(hash.component2()))
}

fun approve(web3j: Web3j,cre:Credentials,address: String){
    val manaToken = MANAToken.load("0x9b591Bf99aE5818AA19fE171099d048039D3Eced", web3j,cre,getSimpleGasPrice(web3j.ethGasPrice().send().gasPrice),BigInteger("8000000"))

    val hash =  manaToken.approve(Address(address), Uint256(BigInteger("10000000000000000000000000"))).send().transactionHash

    print(hash)
}


//
val x1 = "2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50"
val y1 ="-12,-13,-14,-15,-16,-17,-18,-19,-20,-21,-22,-23,-24,-25,-26,-27,-28,-29,-30,-31,-32,-33,-34,-35,-36,-37,-38,-39,-40,-41,-42,-43,-44,-45,-46,-47,-48,-49,-50"

fun getXy1(xNum:String): Pair<DynamicArray<Int256>, DynamicArray<Int256>> {
    //获取x轴
    var xa = ""
    repeat(39){
        xa= xa.plus("$xNum,")
    }
    //获取x轴
    val list = xa.substring(0,xa.length-1).split(",").map {
        Int256(BigInteger("$it"))
    }
    val x = DynamicArray(list)

    //获取y轴
    val list2 = y1.split(",").map {
        Int256(BigInteger("$it"))
    }
    val y = DynamicArray(list2)

    return x to y
}


fun getXy2(yNum:String): Pair<DynamicArray<Int256>, DynamicArray<Int256>> {
    //获取x轴
    var ya = ""
    repeat(39){
        ya= ya.plus("$yNum,")
    }
    //获取x轴
    val list = ya.substring(0,ya.length-1).split(",").map {
        Int256(BigInteger("$it"))
    }
    val y = DynamicArray(list)
    //获取y轴
    val list2 = x1.split(",").map {
        Int256(BigInteger("$it"))
    }
    val x = DynamicArray(list2)

    return x to y
}


fun getXy3(xNum:String,yNum: String): Pair<DynamicArray<Int256>, DynamicArray<Int256>> {
    //获取x轴

    val y = DynamicArray(Int256(BigInteger(yNum)))
    //获取y轴

    val x = DynamicArray(Int256(BigInteger(xNum)))

    return x to y
}


fun addWearables(contractAddr:String,web3j: Web3j,cre:Credentials,staticGasProvider:StaticGasProvider,wearableIds:MutableList<ByteArray>,maxIssuances:MutableList<BigInteger>){
    val erC721Collection =  ERC721Collection.load(contractAddr,web3j,cre,staticGasProvider)

    val hash =  erC721Collection.addWearables(wearableIds,maxIssuances).send().transactionHash

    print(hash)
}


fun deployErc721(name:String,symbol:String,baseUri:String,web3j: Web3j,cre:Credentials,staticGasProvider:StaticGasProvider){
    val address =  ERC721Collection.deploy(web3j,cre,staticGasProvider,name,symbol,"0x630959e5ae57d1165c29b5adc2f77c2bb8b730a0",baseUri).send().contractAddress
    print(address)
}



fun otherTest(){
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
}


fun getJsonString(): String{
    val jsonFile = File(TestJava().javaClass.getResource("/test.json").file)
    return try {
        FileUtils.readFileToString(jsonFile)
    } catch (e: IOException) {
        e.printStackTrace()
        ""
    }
}

fun getIp(): String {
   return "${(10..200).random()}.${(2..255).random()}.${(2..200).random()}.${(1..255).random()}"
}



