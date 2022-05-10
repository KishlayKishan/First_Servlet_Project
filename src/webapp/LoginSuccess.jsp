<%--
  Created by Eclipse IDE.
  User: Kishlay_Kishan
  Date: 03-05-2022
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success</title>
    <style>
        body{
            display: flex;
            flex-direction: column;
            align-items: center;
            background: url(https://cdn.hipwallpaper.com/i/31/76/E8FiYD.jpg)
        }
    </style>
</head>
<body>
<h3><span style="color: white; size: 50px "> Hi <%= request.getAttribute("user")%>, Login Successful</span></h3>
<a href ="/login.html"></a>
</body>
</html>
