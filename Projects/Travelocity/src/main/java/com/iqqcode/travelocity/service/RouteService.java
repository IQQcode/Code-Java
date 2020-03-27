package com.iqqcode.travelocity.service;


import com.iqqcode.travelocity.domain.PageBean;
import com.iqqcode.travelocity.domain.Route;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-27 14:29
 * @Description:线路Service
 */
public interface RouteService {
    /**
     * 根据分类类别进行数据分页
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<Route> pageQuery(int cid, int currentPage, int pageSize);
}
