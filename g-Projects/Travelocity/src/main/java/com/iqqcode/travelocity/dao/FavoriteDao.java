package com.iqqcode.travelocity.dao;


import com.iqqcode.travelocity.domain.Favorite;
import com.iqqcode.travelocity.domain.Route;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-29 10:07
 * @Description:
 */
public interface FavoriteDao {
    /**
     * 根据rid和uid查询收藏信息
     * @param rid
     * @param uid
     * @return
     */
    Favorite findByRidAndUid(int rid, int uid);

    /**
     * 根据rid 查询收藏次数
     * @param rid
     * @return
     */
    int findCountByRid(int rid);

    /**
     * 添加收藏
     * @param rid
     * @param uid
     */
    void add(int rid, int uid);

}

