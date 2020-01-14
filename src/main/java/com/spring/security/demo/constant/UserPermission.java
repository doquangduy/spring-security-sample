package com.spring.security.demo.constant;

public enum UserPermission {
    ADM00001("ADM00001", "ADMIN"),
    USER00001("USER00001", "USER");
    String code;
    String description;

    UserPermission(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }
}
