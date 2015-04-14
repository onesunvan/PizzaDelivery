<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Save pizza</title>
    </head>
    <body>
        <form action="savePizza" method="POST">
            <input type="text" placeholder="Name" name="name"/><br/>
            <input type="number" placeholder="Price" name="price" step="any"/><br/>
            <select name="type">
                <option value="MEAT">MEAT</option>
                <option value="VEGAN">VEGAN</option>
                <option value="MIX">MIX</option>
            </select><br/>
            <input type="submit" value="Save pizza"/>
        </form>
    </body>
</html>
