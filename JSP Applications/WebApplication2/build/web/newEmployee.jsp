<%-- 
    Document   : newEmployee
    Created on : 01.11.2017, 15:01:07
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Новый Сотрудник</title>
    </head>
    <body>
        <h1>Введите информацию о новом сотруднике</h1>
        <form name="newemployee" action="NewEmployeeServlet">
            <input type="text" name="id" value="Enter Id" size="30" />
            <input type="text" name="first_name" value="Enter first name" size="30" />
            <input type="text" name="last_name" value="Enter last name" size="30" />
            <input type="text" name="designation" value="Enter designation" size="30" />
            <input type="text" name="phone" value="enter phone" size="30" />
            <input type="submit" value="submit" name="Добавить!" />
        </form>
        
        
    </body>
</html>
