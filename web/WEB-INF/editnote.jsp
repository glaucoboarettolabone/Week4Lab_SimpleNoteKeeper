<%-- 
    Document   : editnote
    Created on : Sep 29, 2020, 8:45:59 AM
    Author     : 815000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note - Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="note">
            <b>Title: </b><input type="text" name="title" value="${note.title}"><br><br>
            <b>Contents:</b><textarea name="contents" rows="10" cols="30">${note.contents}</textarea><br><br>
            <input type="submit" value="Save">
        </form>
            
        <c:if test="${invalid == true}">
            <p>Invalid entry. Please enter both the title and the contents.</p>
        </c:if>
    </body>
</html>
