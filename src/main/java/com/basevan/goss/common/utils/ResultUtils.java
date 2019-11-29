package com.basevan.goss.common.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * <p></p>
 *
 * @Author: basevan.tang   2019/11/27
 */
public class ResultUtils{

    public static JSONObject success(Object data){
        JSONObject json = new JSONObject();
        json.put("code", 200);
        json.put("msg", "操作成功");
        json.put("data", data);
        return json;
    }

    public static JSONObject fail(){
        JSONObject json = new JSONObject();
        json.put("code", 500);
        json.put("msg", "操作失败");
        return json;
    }
}
