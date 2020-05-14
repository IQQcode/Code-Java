package com.iqqcode.travelocity.dao;


import com.iqqcode.travelocity.domain.Seller;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-28 18:53
 * @Description:查询商家对象
 */
public interface SellerDao {
    /**
     * 根据route的sid（商家id）查询商家对象
     * @param id
     * @return
     */
    Seller findById(int id);
}
