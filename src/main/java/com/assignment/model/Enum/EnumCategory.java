package com.assignment.model.Enum;

public enum EnumCategory {
    ACTIVE(1,"ACTIVE"),
    DEACTIVATED(2,"DEACTIVATED"),
    DELETED(3,"DELETED");

    private int value;
    private String key;



    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    EnumCategory(int value, String key) {
        this.value = value;
        this.key = key;
    }

    EnumCategory() {
    }
}
