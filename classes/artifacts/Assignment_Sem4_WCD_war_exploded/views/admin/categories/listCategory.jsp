<%@ include file="../../../taglibs/taglib.jsp" %>
<%--<head>--%>

<%--</head>--%>

<h1 class="mb-5  text-center">List Category</h1>
<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <c:url var="addCtUrl" value="/admin/category/add"/>
        <h6 class="m-0 font-weight-bold text-primary"><a href="${addCtUrl}">Add New Category</a></h6>
    </div>
    <div class="card-body" >
        <div class="table-responsive" >
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0" style="text-align-last: center">
                <thead>
                <tr>
                    <th style="padding-left: 2%">Id</th>
                    <th style="padding-left: 2%">Name</th>
                    <th style="padding-left: 2%">Image</th>
                    <th style="padding-left: 2%">Description</th>
                    <th style="padding-left: 2%">Status</th>
                    <th style="padding-left: 2%">Action</th>
                </tr>
                </thead>
                <%--                                <tfoot>--%>
                <%--                                <tr>--%>
                <%--                                    <th>Id</th>--%>
                <%--                                    <th>Name</th>--%>
                <%--                                    <th>Status</th>--%>
                <%--                                </tr>--%>
                <%--                                </tfoot>--%>
                <tbody>
                <c:forEach var="item" items="${requestScope.getListCategory}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>
                            <div class="text-center">
                                <img src="${item.image}" class="rounded" alt="..." onerror="this.onerror = null; this.src='https://www.tibs.org.tw/images/default.jpg'" width="100px" height="100px">
                            </div>
                        </td>
                        <td>${item.description}</td>
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
                        <c:url value="/admin/category/update" var="urlUpdateCT">
                            <c:param name="id" value="${item.id}"/>
                        </c:url>
                        <c:url value="/admin/category/delete" var="urlDeleteCT">
                            <c:param name="id" value="${item.id}"/>
                        </c:url>
                            <%--<c:set var="idCtUpdate" value='${pageContext.request.contextPath}/admin-updateCategory?id=${item.id}'/>--%>
                            <%--<c:set var="idCtDelete" value='${pageContext.request.contextPath}/admin-deleteCategory?id=${item.id}'/>--%>
                        <td><a href="${urlUpdateCT}"><i class="fas fa-edit"></i></a>
                            &nbsp;|&nbsp;
                            <a href="${urlDeleteCT}"><i class="fas fa-trash"></i></a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- Bootstrap core JavaScript-->




