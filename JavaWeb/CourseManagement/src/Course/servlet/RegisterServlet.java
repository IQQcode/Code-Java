package Course.servlet;

import Course.Dao.StudentDao;
import Course.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import static java.lang.System.out;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset = utf-8");
        String userid = request.getParameter("userId");
        String username = request.getParameter("uerName");
        String userpassword = request.getParameter("userPassword");
        String major = request.getParameter("major");
        String grade = request.getParameter("grade");
        String sclass = request.getParameter("sclass");

        Student user = new Student();
        user.setId(userid);
        user.setName(username);
        user.setPassword(userpassword);
        user.setMajor(major);
        user.setGrade(grade);
        user.setSclass(sclass);

        StudentDao dao = new StudentDao();
        try {
            Connection conn = dao.getConnection();
            if(conn != null) {
                out.print("conn is not null");
            }
            if(dao.addUser(user)){
                out.print("注册成功！");
                response.sendRedirect("login.jsp");
            }
            else{
                out.print("注册失败！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
