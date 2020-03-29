package com.iqqcode.travelocity.service;


import com.iqqcode.travelocity.domain.PageBean;
import com.iqqcode.travelocity.domain.Route;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-29 10:06
 * @Description:
 */
public interface FavoriteService {
    /**
     * 判断是否收藏
     * @param rid
     * @param uid
     * @return
     */
    boolean isFavorite(String rid, int uid);

    /**
     * 添加收藏
     * @param rid
     * @param uid
     */
    void add(String rid, int uid);

    void addCount(String rid);

    List<Route> findByUid(int uid);

    PageBean findRouteOrderPageBean(String cid, String currentPage, String cname, String highPrice, String lowPrice, String pageSize);
}
