<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: ken
  Date: 2019/11/13
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Web Application Tutorial Page</title>
  </head>
  <body>
    <h1>Hello World</h1>
    <p>Body text.<br>This is my first WebPage JSP page.</p>

  <%
    Date date = new Date();
    out.print("<h2>" + date.toString() + "</h2>");
  %>
  </body>
</html>
