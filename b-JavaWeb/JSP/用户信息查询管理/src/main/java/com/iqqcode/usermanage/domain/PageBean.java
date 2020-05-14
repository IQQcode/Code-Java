package com.iqqcode.usermanage.domain;


import lombok.Data;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-25 09:42
 * @Description:分页对象
 */
@Data
public class PageBean<T> {
    private int totalCount; //总记录数
    private int totalPage; //总页码
    private List<T> list; //每页的数据list集合
    private int currentPage; //当前页码
    private int rows; //每页记录的条数
}
