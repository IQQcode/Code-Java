package org.iqqcode.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-11 14:13
 * @Description:根据queryVo中的条件查询用户
 * 多个对象组成的查询条件，进行数据的查询
 */
@Data
public class QueryVo implements Serializable {

    private User user;
}
