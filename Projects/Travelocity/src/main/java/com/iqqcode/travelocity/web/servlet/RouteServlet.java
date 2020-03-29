package com.iqqcode.travelocity.web.servlet;

import com.iqqcode.travelocity.domain.PageBean;
import com.iqqcode.travelocity.domain.Route;
import com.iqqcode.travelocity.service.RouteService;
import com.iqqcode.travelocity.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-27 14:00
 * @Description:分类信息分页展示
 *
 * totalCount 总记录数
 * totalPage 总页数
 * currentPage 当前页码
 * pageSize 每页显示的条数
 * List<T> list 每页显示的数据集合
 */

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {

    private RouteService routeService = new RouteServiceImpl();

    /**
     * 分页查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");

        //接受rname 线路名称
        String rname = request.getParameter("rname");
        rname = new String(rname.getBytes("iso-8859-1"), "utf-8");


        //处理参数
        int cid = 0; //分类类别id
        //cidStr不存在或为空字符串不做处理
        if (cidStr != null && cidStr.length() > 0 && !"null".equals(cidStr)) {
            cid = Integer.parseInt(cidStr);
        }

        //当前页码，如果不传递，则默认为第一页
        int currentPage = 0;
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1; //第一页
        }

        //每页显示条数，如果不传递，默认每页显示5条记录
        int pageSize = 0;
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 5;
        }

        //3. 调用service查询PageBean对象
        PageBean<Route> pb = routeService.pageQuery(cid, currentPage, pageSize, rname);

        //4. 将pageBean对象序列化为json，返回
        writeValue(response, pb);
    }

    /**
     * 根据id查询旅游线路的详情
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findRouteDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收id
        String rid = request.getParameter("rid");
        //2.调用service查询route对象
        Route route = routeService.findRouteDetails(rid);
        //3.转为json写回客户端
        writeValue(response, route);
    }
}
