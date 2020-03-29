package com.iqqcode.travelocity.service.impl;


import com.iqqcode.travelocity.dao.RouteDao;
import com.iqqcode.travelocity.dao.RouteImgDao;
import com.iqqcode.travelocity.dao.SellerDao;
import com.iqqcode.travelocity.dao.impl.RouteDaoImpl;
import com.iqqcode.travelocity.dao.impl.RouteImgDaoImpl;
import com.iqqcode.travelocity.dao.impl.SellerDaoImpl;
import com.iqqcode.travelocity.domain.PageBean;
import com.iqqcode.travelocity.domain.Route;
import com.iqqcode.travelocity.domain.RouteImg;
import com.iqqcode.travelocity.domain.Seller;
import com.iqqcode.travelocity.service.RouteService;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-27 14:30
 * @Description:
 */
public class RouteServiceImpl implements RouteService {

    private RouteDao routeDao = new RouteDaoImpl();
    private RouteImgDao routeImgDao = new RouteImgDaoImpl();
    private SellerDao sellerDao = new SellerDaoImpl();


    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rnaem) {
        //封装PageBean
        PageBean<Route> pb = new PageBean<Route> ();

        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);

        //设置总记录数
        int totalCount = routeDao.findTotalCount(cid, rnaem);
        pb.setTotalCount(totalCount);

        //设置当前页显示的数据集合
        /*当前页开始显示的记录位置*/
        /* start = (当前页码 - 1) * pageSize */
        int start = (currentPage - 1) * pageSize;
        List<Route> list = routeDao.findByPage(cid, start, pageSize, rnaem);
        pb.setList(list);

        //设置总页数 = 总记录数/每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public Route findRouteDetails(String rid) {
        //1.根据id去route表中查询route对象
        Route route = routeDao.findRouteDetails(Integer.parseInt(rid));

        //2.根据route的id 查询图片集合信息
        List<RouteImg> routeImgList = routeImgDao.findByRid(route.getRid());
        //2.2将集合设置到route对象
        route.setRouteImgList(routeImgList);

        //3.根据route的sid（商家id）查询商家对象
        Seller seller = sellerDao.findById(route.getSid());
        route.setSeller(seller);

        return route;
    }
}
