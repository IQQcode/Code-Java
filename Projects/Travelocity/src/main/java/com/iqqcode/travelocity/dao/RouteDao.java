package com.iqqcode.travelocity.dao;


import com.iqqcode.travelocity.domain.Route;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-27 14:32
 * @Description:
 */
public interface RouteDao {
    /**
     * 根据cid查询总记录数
     * @param cid
     * @return
     */
    int findTotalCount(int cid);


    /**
     * 根据cid，start,pageSize查询当前页的要显示的数据集合
     * @param cid
     * @param start
     * @param pageSize
     * @return
     */
    List<Route> findByPage(int cid , int start , int pageSize);
}
