package com.company.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringUtils {

    private static Logger log = LogManager.getLogger(StringUtils.class);

    public static String repeat(char cr, int len) {
        if(len<=0)
            return "";
        char[] charArray = new char[len];
        return (new String(charArray)).replace(charArray[0], cr);
    }

    public static String rightPad(String str, int len, char pad){
        int padLength = len - str.length();
        String padString = repeat(pad,padLength);
        return str + padString;
    }

    public static String rightPad(String str, int len) {
        return rightPad(str, len, ' ');
    }

    public static String[] splitURL(String url){
        String[] urlSections = url.split("/",0);
        return urlSections;
    }

    public static boolean isNullEmptyOrWhiteSpace(String s) {
        return s==null || s.trim().isEmpty();
    }

    public static Map<String,String> createMapFromCommaSeparatedNameValuePairs(String pairs){
        Map<String,String> map = new HashMap<String,String>();
        if(isNullEmptyOrWhiteSpace(pairs))
            return map;
        String[] splitedPairs = pairs.split(",");
        for(String pair : splitedPairs){
            String[] nameValue = pair.split("=",2);
            if(nameValue.length < 2)
                log.warn("Attribute <" + pair + "> is not a valid name/value pair");
            else
                map.put(nameValue[0].trim(),nameValue[1].trim());
        }
        return map;
    }

    public static Set<String> createSetFromCommaSeparatedValues(String values){
        Set<String> set = new HashSet<String>();
        if(isNullEmptyOrWhiteSpace(values))
            return set;
        String[] splitedValues = values.split(",");
        for(String value : splitedValues)
            set.add(value.trim());
        return set;
    }
}
