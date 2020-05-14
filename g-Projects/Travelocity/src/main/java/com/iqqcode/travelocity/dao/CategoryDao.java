package com.iqqcode.travelocity.dao;


import com.iqqcode.travelocity.domain.Category;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-26 15:52
 * @Description:
 */
public interface CategoryDao {
    /**
     * 查询所有分类项
     * @return
     */
    List<Category> findSort();
}
