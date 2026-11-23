
<%@ page language="java" %>
<%@ page import="isep.lab1.bean.Person" %>

<html>
<head>
    <title>Person Information</title>
</head>

<body>

    <jsp:useBean id="person" class="isep.lab1.bean.Person" scope="request" />

    <jsp:setProperty name="person" property="*" />

    <h2>Person Information</h2>

    First Name: <jsp:getProperty name="person" property="firstName" />
    <br>

    Last Name: <jsp:getProperty name="person" property="lastName" />
    <br>

    Birth Day: <jsp:getProperty name="person" property="birthDay" />
    <br>

    Sex: <jsp:getProperty name="person" property="sex" />

</body>
</html>
