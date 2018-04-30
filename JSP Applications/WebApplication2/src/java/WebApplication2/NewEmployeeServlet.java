/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebApplication2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ivan
 */
public class NewEmployeeServlet extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
// Получение из http-запроса значения параметра lasname
String ID=request.getParameter("id");
String FirstName=request.getParameter("first_name");
String Designation=request.getParameter("designation");
String Phone=request.getParameter("phone");
String lastname = request.getParameter("last_name");
Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
Connection con = DriverManager.getConnection(
"jdbc:derby://localhost:1527/myDB;create=true;user=student;password=student");
// Выполнение SQL-запроса
PrintWriter out = response.getWriter();
PreparedStatement pst = con.prepareStatement("insert into employee values(?,?,?,?,?)");
pst.setString(1,ID);
pst.setString(2,FirstName);
pst.setString(3,lastname);
pst.setString(4,Designation);
pst.setString(5,Phone);
int i = pst.executeUpdate();
if(i!=0){
out.println("</br>Данные добавлены в базу</br>");
try{
       RequestDispatcher rd=request.getRequestDispatcher("newEmployee.jsp");  
        rd.include(request, response);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
}
else{
out.println("</br>Ошибка добавления, попытайтесь снова!</br>");
try{
       RequestDispatcher rd=request.getRequestDispatcher("newEmployee.jsp");  
        rd.include(request, response);
        }catch(Exception ex){
        ex.printStackTrace();
        
        }
}

        }catch (Exception ex) {
ex.printStackTrace();
throw new ServletException(ex);
}
//        try{
//        response.sendRedirect("newEmployee.jsp");  
//        }catch(Exception ex){
//        ex.printStackTrace();
        
//        }
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
