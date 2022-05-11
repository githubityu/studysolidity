package com.ityu.util

import com.ityu.util.JsonUtil.getObjectNode
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody


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
    val toRequestBody = "0x6f9301Df6DF8Ad6B18De4CbA665B9fc09f377219".toRequestBody("application/rawdata".toMediaType())
    val post = Request.Builder().url("https://faucet.metamask.io/v0/request").post(toRequestBody).build()
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
