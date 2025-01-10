package com.bigf.furn.util;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // getter,setter,tostring
@NoArgsConstructor //无参构造
public class Result<T> {
    private String code; //status code
    private String msg;  // taken message
    private T data;      // return type,select type when object be created

    //指定返回的数据雷系
    public Result(T data) {
        this.data = data;
    }

    //返回不带参数的成功信息
    public static Result success() {
        Result<Object>  objectResult=new Result<>();
        objectResult.setCode("200");
        objectResult.setMsg("success");
        return objectResult;
    }

    //返回带参数的成功信息
    public static <T> Result<T> success(T data) {
        Result<T> tResult=new Result<>(data);
        tResult.setCode("200");
        tResult.setMsg("success");
        return tResult;
    }

    //返回不带参数的失败信息
    public static Result error(String code, String msg) {
        Result<Object> objectResult=new Result();
        objectResult.setCode(code);
        objectResult.setMsg(msg);
        return objectResult;
    }

    //返回带参宿的失败信息
    public static <T> Result<T> error(String msg,String code,T data) {
        Result<T> tResult=new Result<>(data);
        tResult.setCode(code);
        tResult.setMsg(msg);
        return tResult;
    }
}
