<%-- 
    Document   : new-book
    Created on : Dec 4, 2015, 11:23:39 AM
    Author     : Szayel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a book</title>
    </head>
    <body>
        <h1>Add a new book</h1>
        <form method="POST">
            <ul>
                <li>
                    <input tye="text" name="ISBN" />
                </li>
                <li>
                    <input type="text" name ="title" />
                </li>
                <li>
                    <input type="text" name ="author" />
                </li>
                <li>
                    <input type="submit" value="Save" />
                </li>
            </ul>
        </form>
    </body>
</html>
