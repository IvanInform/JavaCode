<%-- 
    Document   : update
    Created on : 01.11.2017, 17:32:31
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Изменить Запись</title>
    </head>
    <body>
            <h1>Измените запись о сотруднике</h1>
        <form name="newemployee" action="UpdateEmployeeServlet">
            <input type="text" name="id" value="<%=request.getParameter("id")%>" size="30" />
            <input type="text" name="first_name" value="<%=request.getParameter("first_name")%>" size="30" />
            <input type="text" name="last_name" value="<%=request.getParameter("last_name")%>" size="30" />
            <input type="text" name="designation" value="<%=request.getParameter("designation")%>" size="30" />
            <input type="text" name="phone" value="<%=request.getParameter("phone")%>" size="30" />
            <input type="submit" value="submit" name="Изменить!" />
        </form>
    </body>
</html>
