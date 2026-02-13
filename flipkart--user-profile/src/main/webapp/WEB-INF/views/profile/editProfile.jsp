<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.flipkart.entity.ProfileEntity" %>

<%
    ProfileEntity profile = (ProfileEntity) request.getAttribute("profile");
%>

<form action="updateProfile" method="post">

    <input type="hidden" name="id" value="<%= profile.getId() %>">

    Email:
    <input type="text" name="email" value="<%= profile.getEmail() %>"><br>

    Mobile:
    <input type="text" name="mobile" value="<%= profile.getMobile() %>"><br>

    <input type="submit" value="Update">
</form>
