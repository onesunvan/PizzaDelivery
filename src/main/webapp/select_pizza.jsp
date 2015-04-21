<%-- 
    Document   : select_pizza
    Created on : Apr 15, 2015, 9:33:38 PM
    Author     : ivan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Виберіть піцу</title>
        <script type="text/javascript" src="<c:url value="resources/main.js"/>">
        </script>
    </head>
    <body>
        <form name="selectIdForm" action="<c:url value="updatePizza/"/>" 
              method="POST" onsubmit="onPizzaFormSubmit()">
            <input type="number" min="1" id="id" placeholder="Id піци"/><br/>
            <input type="submit" value="Знайти піцу"/>
        </form>
    </body>
</html>
