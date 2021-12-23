<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>

<html>
<head>
    <title>Error occurred</title>
</head>
<body>
<h1>Error has occurred</h1>
Exception: <%=exception%><br/>
Message: <%=exception.getMessage()%><br/>
</body>
</html>
