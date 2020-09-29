<%-- 
    Document   : viewnote
    Created on : Sep 29, 2020, 8:45:44 AM
    Author     : 815000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note - Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2
        <b>Title: </b>${note.title}<br><br>
        <b>Contents:</b><br>${note.contents}<br><br>
        <a href="note?type=insert">Insert</a>
        <a href="note?type=edit">Edit</a>
        <a href="note?type=delete">Delete</a>        
    </body>
</html>
