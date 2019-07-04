package Course.servlet;

import Course.Database.Dbutil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset = utf-8");
        PrintWriter out = response.getWriter();
        String stuid = request.getParameter("stuid");
        String stupass = request.getParameter("stupassoword");
        Dbutil db = new Dbutil();
        try {
            db.getConnection();

        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        String sql = "SELECT sid,spassword FROM student WHERE sio = ? AND spassword = ?";
        ResultSet rs = db.executeQuery(sql,new String[]{stuid,stupass});
        try {
            if(rs!= null || rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("numSession", stuid);
                Cookie cookie = new Cookie("stuno",stuid);
                cookie.setMaxAge(60 * 60 * 24 * 30);
                response.addCookie(cookie);

                //登录成功，跳转...

                RequestDispatcher dispatcher = request.getRequestDispatcher("/FindServlet");
                dispatcher.forward(request,response);
            } else {
                out.print("登录失败");
                out.print("<br><a href = 'login.jsp'>重新登陆</a>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void init()throws ServletException { }
}
