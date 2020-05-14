package com.iqqcode.travelocity.dao;


import com.iqqcode.travelocity.domain.RouteImg;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-28 18:43
 * @Description:查询出的路线详情信息——图片集合
 */
public interface RouteImgDao {
    /**
     * 根据线路Route id来查询图片信息
     * @param rid
     * @return
     */
    List<RouteImg> findByRid(int rid);
}
