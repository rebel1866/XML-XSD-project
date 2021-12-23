<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> XML Parser</title>
</head>
<body>
<div style=" margin: 150px 300px 380px 350px; ">
    <form action="parserServlet" method="post" enctype="multipart/form-data">
        <c:out value="Файл xml:"/>
        <input type="file" name="file" size="50"/> <br/><br/>
        <c:out value="Файл xsd:"/>
        <input type="file" name="file" size="50"/>
        <br/><br/>
        <c:out value="Выберите парсер:"/>
        <select name="parserType">
            <option selected value="DOM"> <c:out value="DOM"/></option>
            <option value="SAX"> <c:out value="SAX"/></option>
            <option value="STAX"> <c:out value="STAX"/></option>
        </select><br/><br/>
        <input type="submit" value="Загрузить"/>
    </form>
</div>
</body>
</html>
