package com.iqqcode.travelocity.service;


import com.iqqcode.travelocity.domain.Category;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-26 15:58
 * @Description:
 */
public interface CategoryService {
    /**
     * 查询所有分类项
     * @return
     */
    List<Category> findSort();
}
