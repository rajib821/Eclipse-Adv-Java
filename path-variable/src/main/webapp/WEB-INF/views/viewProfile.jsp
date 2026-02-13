<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

Successfully created profile. <br><br>

<a href="viewProfileById?id=${id}">View My Profile</a>
<a href="viewProfileById?id=<%= request.getAttribute("id") %>">View Profile</a>

