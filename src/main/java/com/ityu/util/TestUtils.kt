package com.ityu.util

import com.fasterxml.jackson.databind.util.JSONPObject
import com.ityu.util.JsonUtil.getObjectNode
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody


fun testHttpClient(){
    val toRequestBody =
        "0x0e2457a0b68023fbd0516aa4c7fdc2e356934fff".toRequestBody("application/json; charset=utf-8".toMediaType())
    val post = Request.Builder().url("https://faucet.metamask.io/v0/request").post(toRequestBody).build()
    val client = getOkHttpClient().newCall(post).execute()
    //0x0000000000000000000000000000000000000000
    println(client.body?.string()?:"====")
}


fun testGetMatic(address:String){
    val apply = getObjectNode().apply {
        put("network", "mumbai")
        put("address", address)
        put("token", "maticToken")
    }
    val toRequestBody =  apply.toString().toRequestBody("application/json; charset=utf-8".toMediaType())
    val post = Request.Builder().url("https://api.faucet.matic.network/transferTokens").post(toRequestBody).build()
    val client = getOkHttpClient().newCall(post).execute()
    //0x0000000000000000000000000000000000000000
    println(client.body?.string()?:"====")
}