package Course.servlet;

import Course.Database.Dbutil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 取消选课
 */
@WebServlet("/CancelServlet")
public class CancelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp);
    }

    protected void process(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {

            Connection conn = (new Dbutil()).getConnection();
            Statement statement = (Statement) conn.createStatement();

            //String keyString = new String(req.getParameter("id").getBytes("iso-8859-1"), "utf-8");
            req.setCharacterEncoding("UTF-8");
            String course = req.getParameter("id");

            if(course == null) {
                course = "";
                resp.sendRedirect("/FindServlet");

                return;
            }

            String numSession = (String) req.getSession().getAttribute("numSession");

            //更新课程数据,取消
            String sql2 = "update student set selected_course=NULL where sno = " + numSession ;
            statement.executeUpdate(sql2);

            //课程余量+1
            String sql3 = "update course set course_Remain=course_Remain+1 where course_Id ="+ course;
            statement.executeUpdate(sql3);

            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.getWriter().print("{\"data\":\"返回json数据！\"}");
    }

}
