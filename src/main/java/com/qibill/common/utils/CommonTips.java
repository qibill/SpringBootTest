package com.qibill.common.utils;

/**
 * 返回成功失败类型
 * @author sxz
 * @date 2018/9/21 上午10:38
 */

public class CommonTips {
    //与数据库交互
    public static final String TIPS_OPERATE_SUCCESS = "成功！";
    public static final String TIPS_OPERATE_FAIL = "失败！";
    public static final String TIPS_OPERATE_FAIL_ALREADY_EXIST = "失败[数据已存在]！";
    public static final String TIPS_OPERATE_FAIL_NOT_EXIST = "失败[不存在此数据或已被修改]！";
    public static final String TIPS_OPERATE_FAIL_ALREADY_USED = "失败[此批号/编号已被使用]！";
    public static final String TIPS_OPERATE_FAIL_NAME_USED = "失败[名称已被使用]";
    public static final String TIPS_OPERATE_FAIL_COLUM_TOOLONG = "失败[字段长度超出限制]";
    public static final String TIPS_OPERATE_FAIL_ALREADY_UPDATE = "失败[数据已被处理]";

    //未与数据库交互 数据验证
    public static final String TIPS_VIRIFY_FAIL_NO_PARAMETER = "失败[无任何参数]！";
    public static final String TIPS_VIRIFY_FAIL_LOSS_INFORMATION = "失败[参数缺失部分关键信息]！";
    public static final String TIPS_VIRIFY_FAIL_NO_DATA = "失败[参数中无数据]！";
    public static final String TIPS_VIRIFY_FAIL_INITIALIZATION = "失败[参数格式有误]！";
}
