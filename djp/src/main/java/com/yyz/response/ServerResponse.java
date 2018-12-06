package com.yyz.response;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Builder
@Data
public class ServerResponse {
        private String code;
        private String message;
        private Object result;
        private Integer count;

     public  static Map<String,Object> success(Object result,Integer count){
         Map<String,Object> map = new HashMap<String,Object>();
         map.put("code","000");
         map.put("msg","success");
         map.put("count",count);
         map.put("data",result);
         return map;
     }
    public  static Map<String,Object> fail(Object result){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code","500");
        map.put("message","fail");
        map.put("result",result);
        return map;
    }

    public  static Map<String,Object> error(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code","100");
        map.put("message","system error");
        map.put("result","系统错误，请联系管理员");
        return map;
    }
}