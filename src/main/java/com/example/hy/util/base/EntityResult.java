package com.example.hy.util.base;

/**
 * 通用返回类型
 */
public class EntityResult {
    private String result;
    private String code;
    private String message;

    public static EntityResult SUCCESS(){
        EntityResult success = new EntityResult();
        success.result = "success";
        success.code = "200";
        return success;
    }

    public static EntityResult ERROR(){
        EntityResult error = new EntityResult();
        error.result = "error";
        error.code = "400";
        return error;
    }

    public static EntityResult ERROR(String message){
        EntityResult error = new EntityResult();
        error.result = "error";
        error.code = "400";
        error.message = message;
        return error;
    }

    public static EntityResult ERROR(String code, String message){
        EntityResult error = new EntityResult();
        error.result = "error";
        error.code = code;
        error.message = message;
        return error;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
