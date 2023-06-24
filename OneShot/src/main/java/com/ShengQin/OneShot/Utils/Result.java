package com.ShengQin.OneShot.Utils;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private int status;
    private String message;
    private T data;

    private Result(int status, String message, T data)  {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public static<T> String success(String msg,T data){
        return toJsonString(new Result(StatusCode.success,msg,data));
    }

    public static String success(String msg){
        return toJsonString(new Result(StatusCode.success,msg,null));
    }

    public static<T> String fail(String msg,T data){
        return toJsonString(new Result(StatusCode.fail,msg,data));
    }

    public static String fail(String msg){
        return toJsonString(new Result(StatusCode.fail,msg,null));
    }
    public static String toJsonString(Object obj){
        return JSON.toJSONString(obj);
    }
}