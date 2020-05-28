<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2019/12/30
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/code">
        姓名:<input type="text" name="username" id="nameId"><br>
        爱好:<input type="checkbox" name="hobby" id="hobbyId" value="抽烟">抽烟
        <input type="checkbox" name="hobby" id="drinkId" value="喝酒">喝酒
        <input type="checkbox" name="hobby" id="hairId" value="烫头">烫头<br>
        <input type="submit" value="提交表单">
    </form>
</body>
</html>
