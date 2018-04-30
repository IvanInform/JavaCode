<%-- 
    Document   : index
    Created on : 01.11.2017, 14:29:56
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="WebApplication2.Employee"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Поиск сотрудников</title>
    </head>
    <body>
        <form action="EmployeeServlet">
Фамилия сотрудника
<input type="text" name="lastname">
<input type=submit value="поиск">
</form>
        </br></br>
        Нажмите на ссылку, чтобы <a href="newEmployee.jsp">Добавить</a>нового сотрудника.</br>
        <%
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
%>
    </body>
</html>
