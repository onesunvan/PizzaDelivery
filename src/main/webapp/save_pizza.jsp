<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Save pizza</title>
    </head>
    <body>
        <form action="<c:url value="/savePizza"/>" method="POST">
            <input type="text" placeholder="Name" id="nameTxt" name="name"/><br/>
            <input type="number" placeholder="Price" id="priceTxt" name="price" step="any"/><br/>
            <select id="typeSlt" name="type">
                <option value="MEAT">MEAT</option>
                <option value="VEGAN">VEGAN</option>
                <option value="MIX">MIX</option>
            </select><br/>
            <input type="submit" value="Save pizza"/>
        </form>
        
        <c:if test="${not empty pizzaToUpdate}">
            <script type="text/javascript">
                document.getElementById("nameTxt").value = "${pizzaToUpdate.name}";
                document.getElementById("priceTxt").value = ${pizzaToUpdate.price};
                document.getElementById("typeSlt").selectedIndex = ${pizzaToUpdate.type.ordinal()};
            </script>
        </c:if>
    </body>
</html>
