package com.soft.classwork.utils;

import com.soft.classwork.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StringUtil {
    private final static Logger logger = LoggerFactory.getLogger(StringUtil.class);

    public static String ListToString(List list){
        String s="";
        if(list != null){
            for (int i=0; i<list.size()-1;i++){
                s+=list.get(i)+",";
            }
            s+=list.get(list.size()-1);
        }
        return s;
    }

    public static List StringToList(String s){
        List list = null;
        if(s!=null){
            list = java.util.Arrays.asList(s.split(","));
        }
        return list;
    }

    public static String ArrayToString(String[] arr){
        String s = "";
        if(arr != null){
            if(arr.length>1){
                for(int i=0;i<arr.length-1;i++){
                    s+=arr[i]+",";
                }
                s+=arr[arr.length-1];
            }else{
                s=arr[0];
            }
        }
        return s;
    }

    public static String[] StringToArray(String s){
        String[] arr;
        String[] arr1 = new String[1];
        if(s == null){
            return null;
        }

        if(s.contains(",")){
            arr = s.split(",");
            return arr;
        }else{
            arr1[0] = s;
            return arr1;
        }
    }
}
