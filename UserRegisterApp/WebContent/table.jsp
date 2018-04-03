<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Table Details</title>

<link rel="stylesheet" href="css/table.css">
</head>
<body>

<% 
List<RegisterBean> list = RegisterDao.getAllRecords();
request.setAttribute("list", list);
%>

<%@page import="com.infosys.*" %>
<%@page import= "java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header>
    <h1>User Details</h1>
    
</header>
<article>
    <h2>Details are here:</h2>
   
    <table class="vitamins">
        <thead>
            <tr>
                <th>NAME</th>
                <th>USERNAME</th>
                <th>EMAIL</th>                
            </tr>
        </thead>
              <tbody>
              <c:forEach items="${list}" var="rb"> 
            <tr>
                <td>${rb.getFirstname()}</td>
                <td>${rb.getUsername()}</td>
                <td>${rb.getEmailid()}</td>
                
            </tr>
            </c:forEach>
        </tbody>
    </table>
</article>
</body>
</html>