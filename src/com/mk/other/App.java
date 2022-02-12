package com.mk.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public static Map<String, Map> map;

    public static void main(String[] args) {
        map = new HashMap();
        String[] cityList = {"中国 浙江 杭州", "中国", "中国 广东", "中国 广东 广州 越秀区"};
        for (String cityStr : cityList) {
            String[] itemList = cityStr.split(" ");
            if (itemList.length > 0) {
                addMap(itemList[0], map);
            }
            if (itemList.length > 1) {
                for (int i = 1; i < itemList.length; i++) {
                    String beforeKey = itemList[i - 1];
                    String key = itemList[i];
                    Map mapOfBeforeKey = addMap(beforeKey, map);
                    Map mapOfKey = addMap(key, map);
                    if (!mapOfBeforeKey.containsKey(key)) {
                        mapOfBeforeKey.put(key, mapOfKey);
                    }
                }
            }
        }

        for (String key : (ArrayList<String>) new ArrayList(map.keySet())) {
            if (!key.equals("中国")) {
                map.remove(key);
            }
        }
        System.out.println(toJSON(map, 0));
    }


    public static Map<String, Map> addMap(String key, Map<String, Map> map) {
        if (!map.containsKey(key)) {
            map.put(key, new HashMap<String, Map>());
        }
        return map.get(key);
    }


    public static String toJSON(Map<String, Map> map, int intend) {
        String str = "{";
        List<String> keys = new ArrayList(map.keySet());
        if (keys.size() > 0) {
            str += "\r\n";
        }
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            str += geneSpace(intend + 2) + key + ": " + toJSON(map.get(key), intend + 2);
            if (i < keys.size() - 1) {
                str += ",";
            }
            str += "\r\n";
        }
        if (keys.size() > 0) {
            str += geneSpace(intend);
        }
        str += "}";
        return str;
    }


    public static String geneSpace(int len) {
        return new String(new char[len]).replace('\0', ' ');
    }
}