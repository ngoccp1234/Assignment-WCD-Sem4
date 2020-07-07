<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/24/2020
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@include file="../taglibs/taglib.jsp" %>
<html>
<head>
    <%--    <title>Home</title>--%>
    <%--include noi dung file head--%>
    <%@include file="../commom/client/head.jsp" %>
</head>
<body>
<%--include noi dung file headerAdmin--%>
<%@include file="../commom/client/header.jsp" %>


<%--include noi dung body--%>
<dec:body/>


<%--include  noi dung file footer--%>
<%@include file="../commom/client/footer.jsp" %>


<%--include noi dung file js--%>
<%@include file="../commom/client/js.jsp" %>
</body>
</html>
