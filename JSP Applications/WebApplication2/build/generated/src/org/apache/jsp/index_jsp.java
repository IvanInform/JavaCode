package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import WebApplication2.Employee;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Поиск сотрудников</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"EmployeeServlet\">\n");
      out.write("Фамилия сотрудника\n");
      out.write("<input type=\"text\" name=\"lastname\">\n");
      out.write("<input type=submit value=\"поиск\">\n");
      out.write("</form>\n");
      out.write("        </br></br>\n");
      out.write("        Нажмите на ссылку, чтобы <a href=\"newEmployee.jsp\">Добавить</a>нового сотрудника.</br>\n");
      out.write("        ");

// Получение значения параметра employeesFound
ArrayList employees = (ArrayList)
request.getAttribute("employeesFound");
// Если параметр задан, начинаем обработку
if (employees != null) {
// Если не найдено ни одного сотрудника - вывод сообщения
if (employees.size()==0)
out.print("Сотрудники не найдены");
else {
out.print("<TABLE border=\"1\">");
// Заголовок таблицы
out.print("<TR><TD>Id</TD><TD>Имя</TD><TD>Фамилия</TD>" +
"<TD>Должность</TD><TD>Телефон</TD></TR>");
for (int i = 0; i < employees.size(); i++) {
// По каждому найденному сотруднику
// формируется строка таблицы
out.print("<TR>");
// Получение очередного сотрудника из коллекции
Employee emp = (Employee) employees.get(i);
// Заполнение строки таблицы свойствами сотрудника
String urlform="?id="+emp.getId()+"&first_name="+emp.getFirstName()
        +"&last_name="+emp.getLastName()+"&designation="+
        emp.getDesignation()+"&phone="+emp.getPhone();
out.print("<TD><a href=\"update.jsp"+urlform+"\">" + emp.getId() + "</a></TD>");
out.print("<TD><a href=\"update.jsp"+urlform+"\">" + emp.getFirstName() + "</a></TD>");
out.print("<TD><a href=\"update.jsp"+urlform+"\">" + emp.getLastName() + "</a></TD>");
out.print("<TD><a href=\"update.jsp"+urlform+"\">" + emp.getDesignation() + "</a></TD>");
out.print("<TD><a href=\"update.jsp"+urlform+"\">" + emp.getPhone() + "</a></TD>");
out.print("</TR>");
}
out.print("</TABLE>");
}
}

      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
