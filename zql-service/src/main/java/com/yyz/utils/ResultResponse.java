package com.yyz.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResultResponse {

    private String code;
    private String message;
    private String result;
    private static ObjectMapper objectMapper=new ObjectMapper();
    public ResultResponse(){}
    public ResultResponse(String code,String message,Object result){
        this.code=code;
        this.message=message;
        try {
            this.result = objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            setCode("001");
            setMessage("服务端类型转换错误");
        }
    }

    public static ResultResponse success(Object result){
        return new ResultResponse("000","success",result);
    }

    public static ResultResponse systemError(){
        return new ResultResponse("100","system error","系统错误，请联系管理员");
    }

    public static ResultResponse fail(Object result){
        return new ResultResponse("500","fail",result);
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

    public Object getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return code+","+message+","+result;
    }
}
