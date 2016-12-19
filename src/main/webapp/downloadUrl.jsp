<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 18.12.16
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список URL</title>
</head>
<body>
<h2><a href="index.html">На главную</a></h2>
<table border="1" cellpadding="8" cellspacing="0">
    <c:forEach items="${linkLists}" var="link">
        <jsp:useBean id="link" scope="page" type="ru.exercise01.model.Link"/>
        <tr>
            <td>
                <%--<ul>--%>
                    <%--<li>--%>
                        <a href="${link.link}">${link.link}</a>
                    <%--</li>--%>
                <%--</ul>--%>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
