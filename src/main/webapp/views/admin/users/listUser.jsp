<%@ include file="../../../taglibs/taglib.jsp" %>
<%--<head>--%>

<%--</head>--%>

<h1 class="mb-5  text-center">List User</h1>
<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <c:url var="addUserUrl" value="/admin/user/add"/>
        <h6 class="m-0 font-weight-bold text-primary"><a href="${addUserUrl}">Add New User</a></h6>
    </div>
    <div class="card-body" >
        <div class="table-responsive" >
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0" style="text-align-last: center">
                <thead>
                <tr>
                    <th style="padding-left: 2%">Id</th>
                    <th style="padding-left: 2%">Name</th>
                    <th style="padding-left: 2%">Email</th>
                    <th style="padding-left: 2%">Phone</th>
                    <th style="padding-left: 2%">Username</th>
                    <th style="padding-left: 2%">Role</th>
                    <th style="padding-left: 2%">Status</th>
                    <th style="padding-left: 2%">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${requestScope.listUser}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.email}</td>
                        <td>${item.phone}</td>
                        <td>${item.username}</td>
                        <td> <c:forEach var="it" items="${item.user_roles}">${it.role.name},
                        </c:forEach></td>
                        <td>
                            <c:set var="status"  value="${item.status}"/>
                            <c:choose>
                                <c:when test="${status == 1}">
                                    <c:out value="ACTIVE"/>
                                </c:when>
                                <c:when test="${status == 2}">
                                    <c:out value="DEACTIVATED"/>
                                </c:when>
                                <c:when test="${status == 3}">
                                    <c:out value="DELETED"/>
                                </c:when>
                                <c:otherwise>
                                    <c:out value="null"/>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <c:url value="/admin/user/update" var="urlUpdateUser">
                            <c:param name="id" value="${item.id}"/>
                        </c:url>
                        <c:url value="/admin/user/delete" var="urlDeleteUser">
                            <c:param name="id" value="${item.id}"/>
                        </c:url>
                        <td><a href="${urlUpdateUser}"><i class="fas fa-edit"></i></a>
                            &nbsp;|&nbsp;
                            <a href="${urlDeleteUser}"><i class="fas fa-trash"></i></a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- Bootstrap core JavaScript-->




