<%-- 
    Document   : index
    Created on : Oct 1, 2013, 2:10:27 PM
    Author     : jude
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Currency Converter</title>
    </head>
    <body>
        <form action="/convert" method="get">
            Amount: <input type="text" name="amount"><br>
            From: <select name="from">
                <option value="USD">USD</option>
                <option value="INR">INR</option>
            </select><br>
            
            To: <select name="to">
                <option value="USD">USD</option>
                <option value="INR">INR</option>
            </select><br>
            <input type="submit" value="Convert">
        </form>
    </body>
</html>
