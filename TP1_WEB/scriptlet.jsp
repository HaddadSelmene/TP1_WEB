<%@ page language="java"%>
<html>

<head>
<title>scriptlet</title>
</head>

<body>
<%@ page import="java.util.Date" %>
<% Date date = new Date(); %>

<%= date %>
<br>
<%= request.getRemoteHost() %>

</body>

</html>