package com.iqqcode.travelocity.service.impl;


import com.iqqcode.travelocity.dao.CategoryDao;
import com.iqqcode.travelocity.dao.impl.CategoryDaoImpl;
import com.iqqcode.travelocity.domain.Category;
import com.iqqcode.travelocity.service.CategoryService;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-26 16:00
 * @Description:
 */
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findSort() {
        return categoryDao.findSort();
    }
}
