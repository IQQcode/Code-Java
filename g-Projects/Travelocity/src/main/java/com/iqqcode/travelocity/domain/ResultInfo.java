package com.iqqcode.travelocity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * 用于封装后端返回前端数据对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultInfo implements Serializable {

    //后端返回结果正常为true，发生异常返回false
    private boolean flag;

    //后端返回结果数据对象
    private Object data;

    //发生异常的错误消息
    private String errorMsg;

    public ResultInfo(boolean flag) {
        this.flag = flag;
    }
    /**
     * 有参构造方法
     * @param flag
     * @param errorMsg
     */
    public ResultInfo(boolean flag, String errorMsg) {
        this.flag = flag;
        this.errorMsg = errorMsg;
    }
}
