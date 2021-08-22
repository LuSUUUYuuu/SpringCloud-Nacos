package com.ice.nacos.result;

import lombok.Data;

/**
 * 统一返回
 * @author yumabing
 * @date 2021/08/03 16:50
 */
@Data
public class Result<T> {

    public static final int SUCCESS_CODE = 200;
    public static final String SUCCESS_MSG = "请求成功";
    public static final int BUSINESS_SUCCESS_CODE = 1;
    public static final int SERVER_ERROR = 500;


    private int retcode; // 返回code
    private String msg; // 返回消息
    private T data; // 返回数据

    public Result() {
        this.retcode = SUCCESS_CODE;
        this.msg = SUCCESS_MSG;
    }

    public Result(T data) {
        super();
        this.data = data;
    }

    public Result(T data,String msg) {
        super();
        this.data = data;
        this.msg = msg;
    }

    public Result(int retcode, String msg) {
        this.retcode = retcode;
        this.msg = msg;
    }

    public Result(int retcode, String msg, T data) {
        this.retcode = retcode;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 快速成功返回
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Result success() {
        return new Result();
    }

    /**
     * 成功并返回对象
     * @return
     */
    public static<T> Result<T> successData(T data) {
        return new Result(1, "SUCCESS", data);
    }



    /**
     * 快速失败返回
     * @param msg
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Result failure(String msg) {
        return new Result(500, msg);
    }
    
    /**
     * 判断是否成功
     * @return
     */
    public Boolean checkSuccess() {
        return this.retcode == SUCCESS_CODE;
    }
    
    @SuppressWarnings("rawtypes")
    public static Boolean checkSuccess(Result result) {
        return result != null && result.getRetcode() == SUCCESS_CODE;
    }
}
