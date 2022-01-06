package com.george.blog.pojo;

import com.george.blog.util.ConstantUtil;
import com.george.blog.util.MsgCodeDesc;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description 统一返回信息码类
 * @date 2021.01.6
 * @author linzhuangze
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO {
    /**
     * 是否成功响应
     */
    private boolean success;
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;

    /**
     * @description 成功响应
     * @date 2021.01.06
     * @author linzhuangze
     * @param data
     * @return
     */
    public static ResultVO success(Object data) {
        return new ResultVO(ConstantUtil.RESPONSE_SUCCESS, MsgCodeDesc.SUCCESS.getCode(),MsgCodeDesc.SUCCESS.getMsg(),data);
    }

    /**
     * @description 失败相应
     * @date 2021.01.06
     * @author linzhuangze
     * @param code
     * @param msg
     * @return
     */
    public static ResultVO fail(Integer code, String msg) {
        return new ResultVO(ConstantUtil.RESPONSE_FAIL,code,msg,null);
    }
}
