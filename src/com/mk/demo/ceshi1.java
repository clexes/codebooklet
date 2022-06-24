package com.mk.demo;

import java.util.*;


/*
* ListltString>中有一组数据，每个元素由字符串和数字组成，前缀为字符串，后面为数字。
要求：前缀相同的取数字最大值的元素。
例如：
元素：ABC001，ABC002，ABC003，ACD001，ACD002
结果取值：ABC003，ACD002
* */

public class ceshi1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("ABC001");
        list.add("ABC002");
        list.add("ABC003");
        list.add("ACD001");
        list.add("ACD002");
        List<String> foo = foo(list);
        for (String s : foo) {
            System.out.println(s);
        }
//        Optional.of().map();
    }

    public static List<String> foo(List<String> list){
        Map<String,String> map = new HashMap<>();
        for (String s : list) {
            String key = s.substring(0,3);
            String value = s.substring(3);
            if(map.get(key)!=null){
                int now = Integer.parseInt(value);
                int after = Integer.parseInt(map.get(key));
                if(now>after){
                    map.put(key,value);
                }
            }else{
                map.put(key,value);
            }
        }
        List<String> array = new ArrayList<>();
        for(String key : map.keySet()){
            array.add(key+map.get(key));
        }
        return array;
    }
}
