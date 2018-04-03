<%@ page import="domain.Book" %><%--
  Created by IntelliJ IDEA.
  User: Saurav Bhandari
  Date: 4/3/2018
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
<%
    Book book = (Book) request.getAttribute("booklist");
%>

<%=book.getAuthor()%>
<%=book.getId()%>
<%=book.getName()%>
<%=book.getCategory()%>

</body>
</html>