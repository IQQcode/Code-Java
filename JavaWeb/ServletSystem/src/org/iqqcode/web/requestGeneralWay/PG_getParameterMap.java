package org.iqqcode.web.requestGeneralWay;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-07 10:19
 * @Description:
 */
@WebServlet("/PG_getParameterMap")
public class PG_getParameterMap extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Map<String,String[]> parameterMap = request.getParameterMap();
        //遍历
        Set<String> setkey = parameterMap.keySet();
        for (String name : setkey) {
            //获取键,获取值
            String[] values = parameterMap.get(name);
            System.out.println(name);
            for (String value : values) {
                System.out.println(value);
            }
            System.out.println("--------------------------");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
