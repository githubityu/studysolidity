package com.ityu.soliditystudy;


import com.ityu.models.TestA;
import com.ityu.models.TestB;
import com.ityu.models.TestConverter;
import org.apache.commons.codec.binary.Hex;

import javax.net.ssl.X509TrustManager;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class TestJava {

    public static class TrustAllCerts implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
    /***
     * 利用Apache的工具类实现SHA-256加密
     *
     * @param str 加密后的报文
     * @return
     */
    public static String getSHA256Str(String str) {
        MessageDigest messageDigest;
        String encdeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
            encdeStr = Hex.encodeHexString(hash);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encdeStr;
    }

    public static void main(String[] args) {
        TestB testB = TestConverter.INSTANCE.fromSource(new TestA(1, "TestA","NameAAA"));
        TestA testA = TestConverter.INSTANCE.toSource(new TestB(1, "TestB","NameBBB"));
        System.out.println(testB.getNameB());
        System.out.println(testA.getNameA());

    }
}



