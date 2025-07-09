package com.example.hello_spring.exception;

public enum ErrorCode {

    UNCATEGORIZED(   9999,  "Uncategorized error"),

    INVALID_KEY(1001, "Uncategorized error"),

    USER_EXISTED(  1002,  "User exits"),

    USERNAME_INVALID(1003, "Username must be at least 3 character"),

    INVALID_PASSWORD(1004, "Password must be at least a character"),

    USER_NOT_EXISTED(1005, "User not existed"),
    UNAUTHENTICATED(1006, "UNAUTHENTICATED");


    private int code;
    private String message;

     ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
