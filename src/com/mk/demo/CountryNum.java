package com.mk.demo;

public enum CountryNum {

    one(1,"齐"),two(2,"楚"),three(3,"燕"),four(4,"赵");

    private int id;
    private String name;

    CountryNum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static CountryNum forEach_CountryNum(int index){
        CountryNum[] values = CountryNum.values();
        for (CountryNum value : values) {
            if (index == value.getId()){
                return value;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
