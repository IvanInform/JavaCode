package WebApplication2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author Ivan
 */

public class EmployeeServlet extends HttpServlet {
public EmployeeServlet() {
super();
}
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmployeeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmployeeServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
       try {
response.setContentType("text/html;charset=UTF-8");
// Получение из http-запроса значения параметра lasname
String lastname = request.getParameter("lastname");
// Коллекция для хранения найденных сотрудников
ArrayList<Employee> employees = new ArrayList<Employee>();
// Загрузка драйвера БД Derby
Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
// Получение соединения с БД
Connection con = DriverManager.getConnection(
"jdbc:derby://localhost:1527/myDB;create=true;user=student;password=student");
// Выполнение SQL-запроса
ResultSet rs = con.createStatement().executeQuery(
"Select id, first_name, last_name, designation, phone "
+ "From employee " + "Where last_name like '"
+ lastname + "'");
// Перечисление результатов запроса
while (rs.next()) {
// По каждой записи выборки формируется
// объект класса Employee.
// Значения свойств заполяются из полей записи
Employee emp = new Employee(
rs.getLong(1),
rs.getString(2),
rs.getString(3),
rs.getString(4),
rs.getString(5));
// Добавление созданного объекта в коллекцию
employees.add(emp);
}
// Закрываем выборку и соединение с БД
rs.close();
con.close();
// Выводим информацию о найденных сотрудниках
//PrintWriter out = response.getWriter();
//out.println("Найденные сотрудники<br>");
//for (Employee emp: employees) {
//out.print(emp.getFirstName() + " " +
//emp.getLastName() + " " +
//emp.getDesignation() + " " +
//emp.getPhone() + "<br>");
//}
request.setAttribute("employeesFound", employees);
// Перенаправление http-запроса на страницу index.jsp
RequestDispatcher dispatcher = getServletContext()
.getRequestDispatcher("/index.jsp");
dispatcher.forward(request, response);
} catch (Exception ex) {
ex.printStackTrace();
throw new ServletException(ex);
}
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
