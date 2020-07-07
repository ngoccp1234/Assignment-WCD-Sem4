<%@ include file="../../../taglibs/taglib.jsp" %>
<h1 class="mb-5  text-center">List Product</h1>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <c:url var="addPUrl" value="/admin/product/add"/>
        <h6 class="m-0 font-weight-bold text-primary"><a href="${addPUrl}">Add New Product</a></h6>
    </div>
    <div class="card-body" >
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0" style="text-align-last: center">
                <thead>
                <tr>
                    <th style="padding-left: 2%">Id</th>
                    <th style="padding-left: 2%">Name</th>
                    <th style="padding-left: 2%">Category</th>
                    <th style="padding-left: 2%">Image</th>
                    <th style="padding-left: 2%">Price</th>
                    <th style="padding-left: 2%">Quantity</th>
                    <th style="padding-left: 2%">Smell</th>
                    <th style="padding-left: 2%">Description</th>
                    <th style="padding-left: 2%">Status</th>
                    <th style="padding-left: 2%">Action</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="item" items="${requestScope.getAllProduct}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.category.name}</td>
                        <td>
                            <div class="text-center">
                                <img src="${item.image}" class="rounded" alt="..." width="100px" height="100px">
                            </div>
                        </td>
                        <td>${item.price}</td>
                        <td>${item.quantity}</td>
                        <td><c:forEach var="att" items="${item.attributes}">
                            <c:out value="${att.name}"/>,
                        </c:forEach>

                        </td>
                        <td>${item.description}</td>
                        <td>
                            <c:set var="status" value="${item.status}"/>
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
                        <c:url value="/admin/product/update" var="urlUpdateP">
                            <c:param name="id" value="${item.id}"/>
                        </c:url>
                        <c:url value="/admin/product/delete" var="urlDeleteP">
                            <c:param name="id" value="${item.id}"/>
                        </c:url>
                            <%--<c:set var="idCtUpdate" value='${pageContext.request.contextPath}/admin-updateCategory?id=${item.id}'/>--%>
                            <%--<c:set var="idCtDelete" value='${pageContext.request.contextPath}/admin-deleteCategory?id=${item.id}'/>--%>
                        <td><a href="${urlUpdateP}"><i class="fas fa-edit"></i></a>
                            &nbsp;|&nbsp;
                            <a href="${urlDeleteP}"><i class="fas fa-trash"></i></a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>

