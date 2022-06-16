<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<input value="${h}">
<input value="${hello.name}">
${h}
${hello.name}
<%= request.getAttribute("h") %>
</body>
</html>