package com.iqqcode.travelocity.service.impl;


import com.iqqcode.travelocity.dao.FavoriteDao;
import com.iqqcode.travelocity.dao.RouteDao;
import com.iqqcode.travelocity.dao.impl.FavoriteDaoImpl;
import com.iqqcode.travelocity.dao.impl.RouteDaoImpl;
import com.iqqcode.travelocity.domain.Favorite;
import com.iqqcode.travelocity.domain.PageBean;
import com.iqqcode.travelocity.domain.Route;
import com.iqqcode.travelocity.service.FavoriteService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-29 10:06
 * @Description:
 */
public class FavoriteServiceImpl implements FavoriteService {

    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public boolean isFavorite(String rid, int uid) {
        Favorite favorite = favoriteDao.findByRidAndUid(Integer.parseInt(rid), uid);
        // 如果这个对象有值，则为true，反之，则为false
        return favorite != null;
    }

    @Override
    public void add(String rid, int uid) {
        favoriteDao.add(Integer.parseInt(rid),uid);
    }

}

