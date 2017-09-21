package com.tr.alidayu.result;

public class Result<T> {

    // 错误码
    private Integer code;

    // 提示信息
    private String msg;

    // 返回数据
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> fail(ResultEnum resEnum) {
        Result<T> result = new Result<>();
        result.setCode(resEnum.getCode());
        result.setMsg(resEnum.getMsg());
        return result;
    }
    
    public static <T> Result<T> fail() {
        return fail(ResultEnum.FAIL);
    }

}
