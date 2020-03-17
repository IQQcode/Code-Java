package com.iqqcode.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iqqcode.domain.Province;
import com.iqqcode.service.Impl.ProvinceServiceImpl;
import com.iqqcode.service.ProvinceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-17 14:47
 * @Description:
 */
@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        /*
        //1.调用service查询
        ProvinceService service = new ProvinceServiceImpl();
        List<Province> list = service.findAll();
        //2.序列化list为JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        */

        ProvinceService service = new ProvinceServiceImpl();
        String json = service.findAllJson();

        System.out.println(json);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
