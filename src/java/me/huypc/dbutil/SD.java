/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.huypc.dbutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class SD {
    public static final String LOGIN_USER = "LOGIN_USER";
    public static final String NOT_IMAGE_FILE = "NOT_IMAGE_FILE";
    public static final String PRODUCT_LIST = "PRODUCT_LIST";
    public static final String ADD_SUCCESS = "ADD_SUCCESS";
    public static final String PRODUCT = "PRODUCT";
    public static final String USER_CARTS = "USER_CARTS";
    public static final String ERROR_ENTITY = "ERROR_ENTITY";
    public static final String ORDER_HEADER = "ORDER_HEADER";
    
    public static final int ROLE_ADMIN = 1;
    public static final int ROLE_MEMBER = 2;
    
    public static final String STATUS_PAID = "STATUS_PAID";
    public static final String STATUS_PENDING = "STATUS_PENDING";
    public static final String STATUS_IN_PROCESS = "STATUS_IN_PROCESS";
    
    public static final String ERROR_PAGE = "error.html";
    
    
    public static String convertToImgSrc(String source) {
        String regex = "([\\\\/]images[\\\\/]products[\\\\/].+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        String result = "";
        while (matcher.find()) {
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            result = matcher.group();
            result = result.replaceFirst("[\\\\/]", "");
            System.out.println(result);
        }
        return result;
    }
    
}
