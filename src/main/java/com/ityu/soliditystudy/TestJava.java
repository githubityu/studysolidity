package com.ityu.soliditystudy;

import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.protocol.http.HttpService;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

public class TestJava {

    public static <T> DynamicArray d(Class<T> type){

        return new DynamicArray(type,new ArrayList());

    }

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

    public static void fs(){

    }

    public static void main(String[] args) {
        System.out.println("fsdfasf");
    }


}


