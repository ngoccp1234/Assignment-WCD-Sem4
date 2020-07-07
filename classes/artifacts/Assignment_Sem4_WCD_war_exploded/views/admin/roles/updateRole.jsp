<%@include file="../../../taglibs/taglib.jsp" %>
<h1 class="text-center" style="margin: 70px 0">Form Update Role</h1>
<br>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4 form-group">
        <form action="/admin/role/update" method="post">
            <input type="hidden" name="idUpdateRole" value="${requestScope.getRole.id}">
            <label style="font-weight: bold">Name: </label>
            <input type="text" name="nameUpdateRole" value="${requestScope.getRole.name}"
                   width="200px" class="form-control">
            <br>
            <label style="font-weight: bold">Description: </label>
            <textarea class="form-control" rows="5" name="descriptionUpdateRole"
                      >${requestScope.getRole.description}
            </textarea>
            <br>
            <label style="font-weight: bold">Status: </label>
            <select name="statusUpdateRole" class="form-control">
                <c:set var="status" value="${requestScope.getRole.status}"/>
                <%--                <option value="${requestScope.getCategory.status}" selected>${requestScope.getCategory.status}</option>--%>
                <c:forEach var="item" items="${requestScope.enumUpdateRole}">
                    <c:set var="statusEnum" value="${item.value}"/>
                    <option value="${statusEnum}" ${status == statusEnum ? "selected" : ""}>
                            ${item.key}

                    </option>
                </c:forEach>
            </select>
            <br>
            <div class="row" style="margin-top: 30px">
                <div class="col-md-6">
                    <button value="Save" type="submit" class="btn btn-outline-primary" style="width: 110px">Save</button>
                </div>
                <div class="col-md-6" style="align-self: center; text-align-last: end">
                    <c:url var="listRoleUrl" value="/admin/roles"/>
                    <a href="${listRoleUrl}"><button type="button" class="btn btn-outline-dark">Back to list</button></a>

                </div>
            </div>
        </form>
    </div>
    <div class="col-md-4"></div>
</div>

