<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/mytags.tld" prefix="m" %>
<html>
<head>
    <title>Flowers</title>
    <style>
        table {
            border-collapse: collapse;
        }

        td {
            border: 1px solid;
            text-align: center;
        }

        th {
            border: 1px solid;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>
            <c:out value="ID:"/>
        </th>
        <th>
            <c:out value="Название:"/>
        </th>
        <th>
            <c:out value="Почва:"/>
        </th>
        <th>
            <c:out value="Происхождение:"/>
        </th>
        <th>
            <c:out value="Цвет стебля:"/>
        </th>
        <th>
            <c:out value="Цвет листьев:"/>
        </th>
        <th>
            <c:out value="Средний размер:"/>
        </th>
        <th>
            <c:out value="Температура:"/>
        </th>
        <th>
            <c:out value="Светолюбивость:"/>
        </th>
        <th>
            <c:out value="Полив в день (мл):"/>
        </th>
        <th>
            <c:out value="Размножение:"/>
        </th>
        <th>
            <c:out value="Дата записи:"/>
        </th>
    </tr>
    <c:forEach items="${flowers}" var="flower">
        <tr>
            <td><m:cutIdTag idValue="${flower.id}"/></td>
            <td><c:out value="${flower.name}"/></td>
            <td><c:out value="${flower.soil}"/></td>
            <td><c:out value="${flower.origin}"/></td>
            <td><c:out value="${flower.stemColor}"/></td>
            <td><c:out value="${flower.leavesColor}"/></td>
            <td><c:out value="${flower.avgFlowerSize}"/></td>
            <td><c:out value="${flower.temperature}"/></td>
            <td><c:out value="${flower.lightening}"/></td>
            <td><c:out value="${flower.watering}"/></td>
            <td><c:out value="${flower.multiplying}"/></td>
            <td><c:out value="${flower.recDateTime}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
