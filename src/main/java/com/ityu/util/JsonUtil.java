package com.ityu.util;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/**
 * 封装json工具类<br>
 * 通过该类减少项目中对特定的json库依赖，方便统一切换json库，目前使用jackson
 *
 * @author ：enilu
 * @date ：Created in 2020/5/31 21:55
 */
public class JsonUtil {
    private static ObjectMapper objectMapper = null;

    private static ObjectMapper objectMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            //如果有特殊处理需求在下面做ObjectMapper的设置

        }
        return objectMapper;
    }

    public static String toJsonForHuman(Object obj) {

        try {
            return objectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String toJson(Object obj) {
        StringWriter sw = new StringWriter();

        try {
            objectMapper().writeValue(sw, obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sw.toString();
    }

    public static String toJsonNotNull(Object obj) {
        StringWriter sw = new StringWriter();

        try {
            objectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
            objectMapper().writeValue(sw, obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sw.toString();
    }

    public static <T> T fromJson(Class<T> klass, String jsonStr) {

        T obj = null;
        try {
            obj = objectMapper().readValue(jsonStr, klass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    public static <T> List<T> fromJsonAsList(Class<T> klass, String jsonStr) {

        List<T> objList = null;
        try {
            JavaType t = objectMapper().getTypeFactory().constructParametricType(
                    List.class, klass);
            objList = objectMapper().readValue(jsonStr, t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return objList;
    }

    /**
     * 判断给定的字符串是否是json格式
     *
     * @param jsonStr
     * @return
     */
    public static boolean isJson(String jsonStr) {
        try {
            if (jsonStr.startsWith("{")) {
                fromJson(Map.class, jsonStr);
            } else {
                fromJsonAsList(Map.class, jsonStr);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static ObjectNode getObjectNode() {
       return  objectMapper().createObjectNode();
    }


    public static void main(String[] args) {

    }

}
