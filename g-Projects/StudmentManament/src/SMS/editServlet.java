package SMS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class editServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8"
                    + "&serverTimezone=UTC";
            String usr="root";
            String password="1234";
            try{
                Class.forName(driver);
                Connection conn=DriverManager.getConnection(url,usr,password);
                String sqlString="UPDATE stulist SET name = ?, sex = ?, age = ?, grade = ?, introduce = ? WHERE id = ?";

                PreparedStatement pstmt=conn.prepareStatement(sqlString);

                int id = Integer.parseInt(request.getParameter("stuid"));
                String name = request.getParameter("stuname");
                String sex = request.getParameter("stusex");
                int age = Integer.parseInt(request.getParameter("stuage"));
                String grade = request.getParameter("stugrade");
                String introduce = request.getParameter("stuintroduce");

                pstmt.setString(1, name);
                pstmt.setString(2, sex);
                pstmt.setInt(3, age);
                pstmt.setString(4, grade);
                pstmt.setString(5, introduce);
                pstmt.setInt(6, id);

                pstmt.executeUpdate();
            }catch(Exception e){
                System.err.println("error:"+e);
            }
            response.sendRedirect("pages/displayStuList.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}