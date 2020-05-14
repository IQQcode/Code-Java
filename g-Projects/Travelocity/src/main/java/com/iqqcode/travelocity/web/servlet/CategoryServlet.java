package com.iqqcode.travelocity.web.servlet;

import com.iqqcode.travelocity.domain.Category;
import com.iqqcode.travelocity.service.CategoryService;
import com.iqqcode.travelocity.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-26 15:49
 * @Description:服务分类
 */
@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {

    private CategoryService service = new CategoryServiceImpl();

    /**
     * 查询所有分类项
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    /**
     * @protected：同类，同包，子类
     * 这个关键字，属实是有点小陷阱。用默认的protected前台怎么也出不来分类信息。
     * 原因就是protected只能在同包或者子类中访问，header.html无法访问到
     */
    public void findSort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service查询所有
        List<Category> cs = service.findSort();
        //序列化json返回
        writeValue(response,cs);
    }
}
