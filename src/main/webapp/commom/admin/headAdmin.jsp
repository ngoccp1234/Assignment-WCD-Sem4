<%--import noi dung ben trong the Head cua template admin--%>
<%@include file="../../taglibs/taglib.jsp" %>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Dashboard</title>

<!-- Custom fonts for this template-->

<link href="<c:url value='/commom/admin/assets/vendor/fontawesome-free/css/all.min.css'/>" rel="stylesheet"
      type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
      rel="stylesheet">

<!-- Custom styles for this template-->
<link href="<c:url value='/commom/admin/assets/css/sb-admin-2.min.css'/>" rel="stylesheet">

<!-- Custom styles for this template -->

<!-- Custom styles for this page -->
<link href="<c:url value='/commom/admin/assets/vendor/datatables/dataTables.bootstrap4.min.css'/>" rel="stylesheet">
<script src="<c:url value='https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js'/>"></script>
<script src="<c:url value='http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js'/>"
        type="text/javascript"></script>
<%--<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>--%>
<%--<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js" type="text/javascript"></script>--%>
<%--<script type="text/javascript">--%>
    <%--$(document).ready(function () {--%>
        <%--$('#AddCategory').validate({--%>
            <%--rules: {--%>
                <%--nameCategory: {--%>
                    <%--required: true,--%>
                    <%--maxlength: 15,--%>
                    <%--minlength: 5--%>
                <%--},--%>
                <%--imageCategory: {--%>
                    <%--required: true,--%>
                    <%--minlength: 5--%>
                <%--},--%>
                <%--descriptionCategory: {--%>
                    <%--required: true,--%>
                    <%--minlength: 5,--%>
                    <%--maxlength: 100--%>
                <%--}--%>

            <%--},--%>
            <%--messages: {--%>
                <%--nameCategory: {--%>
                    <%--required: "Bắt buộc nhập nameCategory",--%>
                    <%--maxlength: "Hãy nhập tối đa 15 ký tự",--%>
                    <%--minlength: "Hãy nhập tối đa 5 ký tự"--%>
                <%--},--%>
                <%--imageCategory: {--%>
                    <%--required: "Bắt buộc nhập imageCategory",--%>
                    <%--minlength: "Hãy nhập tối đa 5 ký tự"--%>
                <%--},--%>
                <%--descriptionCategory: {--%>
                    <%--required: "Bắt buộc nhập imageCategory",--%>
                    <%--maxlength: "Hãy nhập tối đa 100 ký tự",--%>
                    <%--minlength: "Hãy nhập tối đa 5 ký tự"--%>
                <%--}--%>
            <%--}--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>
