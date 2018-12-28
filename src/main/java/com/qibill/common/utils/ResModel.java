package com.qibill.common.utils;


import org.springframework.stereotype.Service;

/**
 * 返回串
 * @author sxz
 * @date 2018/9/21 上午10:38
 */

@Service
public class ResModel<T> extends CommonTips {
    /**
     * 返回串model
     * code:200 (成功);code:300 (警告);code:400 (失败)
     */
    private String result;
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

/*    public String toString() {
        return JSON.toJSONString(this);
    }

    public String warn(String result) {
        code = 300;
        this.result = result;
        return "[" + JSON.toJSONString(this) + "]";
    }

    public String success(String result) {
        code = 200;
        this.result = result;
        return "[" + JSON.toJSONString(this) + "]";
    }

    public String fail(String result) {
        code = 400;
        this.result = result;
        return "[" + JSON.toJSONString(this) + "]";
    }

    public String success() {
        code = 200;
        result = TIPS_OPERATE_SUCCESS;
        return "[" + JSON.toJSONString(this) + "]";
    }

    public String fail() {
        code = 400;
        result = TIPS_OPERATE_FAIL;
        return "[" + JSON.toJSONString(this) + "]";
    }

    public String warn_loss_param() {
        code = 300;
        result = TIPS_VIRIFY_FAIL_LOSS_INFORMATION;
        return "[" + JSON.toJSONString(this) + "]";
    }

    public String warn_exist_name() {
        code = 300;
        result = TIPS_OPERATE_FAIL_NAME_USED;
        return "[" + JSON.toJSONString(this) + "]";
    }

    public String warn_colum_toolong() {
        code = 300;
        result = TIPS_OPERATE_FAIL_COLUM_TOOLONG;
        return "[" + JSON.toJSONString(this) + "]";
    }

    public String warn_exist_data() {
        code = 300;
        result = TIPS_OPERATE_FAIL_ALREADY_EXIST;
        return "[" + JSON.toJSONString(this) + "]";
    }

    *//**
     * 参数初始化失败
     *//*
    public String warn_initialization_fail() {
        code = 300;
        result = TIPS_VIRIFY_FAIL_INITIALIZATION;
        return "[" + JSON.toJSONString(this) + "]";
    }

    *//**
     * 数据已经被更新
     *//*
    public String fail_already_update() {
        code = 400;
        result = TIPS_OPERATE_FAIL_ALREADY_UPDATE;
        return "[" + JSON.toJSONString(this) + "]";
    }

    public String list(T t) {
        return JSON.toJSONString(t);
    }

    public String listContainRows(T t) {
        return "{\"Rows\":" + JSON.toJSONString(t, SerializerFeature.WriteMapNullValue) + "}";
    }

    public String listContainRowsWithoutNull(T t) {
        return "{\"Rows\":" + JSON.toJSONString(t) + "}";
    }*/
}
