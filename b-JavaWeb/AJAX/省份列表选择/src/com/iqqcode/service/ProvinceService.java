package com.iqqcode.service;


import com.iqqcode.domain.Province;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-17 13:47
 * @Description:
 */
public interface ProvinceService {
    public List<Province> findAll();

    public String findAllJson();
}
