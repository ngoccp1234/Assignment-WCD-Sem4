<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../taglibs/taglib.jsp"%>

<html>
<head>

    <%--    <title>Admin</title>--%>
    <%--include noi dung file headAdmin--%>
    <%--        <dec:head>--%>

    <%--        </dec:head>--%>
    <%@include file="../commom/admin/headAdmin.jsp" %>
</head>
<body id="page-top">
<div id="wrapper">
    <%@include file="../commom/admin/menuAdmin.jsp" %>
    <%--include noi dung file headerAdmin--%>

    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">
            <%@include file="../commom/admin/headerAdmin.jsp" %>
            <%--include noi dung body--%>
            <div class="container-fluid">
                <dec:body/>
            </div>
        </div>
        <%--include  noi dung file footerAdmin--%>
        <%--<%@include file="../commom/admin/menuAdmin.jsp"%>--%>
        <%@include file="../commom/admin/footerAdmin.jsp" %>
    </div>
</div>
<%--include noi dung file jsAdmin--%>
<%@include file="../commom/admin/jsAdmin.jsp" %>
</body>
</html>
