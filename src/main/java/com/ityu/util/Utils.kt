package com.ityu.util

import com.ityu.soliditystudy.TestJava
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.web3j.abi.datatypes.generated.Bytes32
import org.web3j.protocol.http.HttpService
import java.security.SecureRandom
import java.time.Duration
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory




fun getOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor {
        println(JsonUtil.toJson(it))
    }
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).hostnameVerifier { p0, p1 ->
        true
    }.sslSocketFactory(createSSLSocketFactory()!!, TestJava.TrustAllCerts()).readTimeout(Duration.ofSeconds(30))
        .connectTimeout(Duration.ofSeconds(30)).build()

}
fun getOkHttpClient2(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor {
        println(JsonUtil.toJson(it))
    }
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
   return HttpService.getOkHttpClientBuilder().addInterceptor(httpLoggingInterceptor).build()

}


//这里是创建一个SSLSocketFactory,提供给上面的 .sslSocketFactory()
private fun createSSLSocketFactory(): SSLSocketFactory? {
    var ssfFactory: SSLSocketFactory? = null
    try {
        val sc: SSLContext = SSLContext.getInstance("TLS")
        sc.init(null, arrayOf(TestJava.TrustAllCerts()), SecureRandom())
        ssfFactory = sc.socketFactory
    } catch (e: Exception) {
    }
    return ssfFactory
}


fun stringToBytes32(string: String): Bytes32 {
    val byteValue = string.toByteArray()
    val byteValueLen32 = ByteArray(32)
    System.arraycopy(byteValue, 0, byteValueLen32, 0, byteValue.size)
    return Bytes32(byteValueLen32)
}