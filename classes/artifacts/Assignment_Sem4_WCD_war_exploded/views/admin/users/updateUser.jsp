<%@include file="../../../taglibs/taglib.jsp" %>
<h1 class="text-center" style="margin: 70px 0">Form Update User</h1>
<br>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4 form-group">
        <form action="/admin/user/update" method="post">
            <input type="hidden" name="idUpdateUser" value="${requestScope.getUserUpdate.id}">
            <label style="font-weight: bold">Name: </label>
            <input type="text" name="nameUpdateUser" value="${requestScope.getUserUpdate.name}"
                   width="200px" class="form-control">
            <br>
            <label style="font-weight: bold">Email: </label>
            <input type="text" name="emailUpdateUser" value="${requestScope.getUserUpdate.email}"
                   width="200px" class="form-control">
            <br>
            <label style="font-weight: bold">Phone: </label>
            <input type="text" name="phoneUpdateUser" value="${requestScope.getUserUpdate.phone}"
                   width="200px" class="form-control">
            <br>
            <label style="font-weight: bold">Username: </label>
            <input type="text" name="usernameUpdateUser" value="${requestScope.getUserUpdate.username}"
                   width="200px" class="form-control">
            <br>
            <input type="hidden" name="passwordUpdateUser" value="${requestScope.getUserUpdate.password}">
            <label style="font-weight: bold">Role: </label>

            <c:forEach var="item" items="${requestScope.getAllRole}">
                <c:forEach var="role" items="${requestScope.getUserUpdate.user_roles}">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" name="roleUpdateUser"
                               value="${item.id}" ${role.roleId == item.id ? "checked" : ""} id="defaultCheck1">
                        <label class="form-check-label" for="defaultCheck1">
                                ${item.name}
                        </label>
                    </div>
                </c:forEach>
            </c:forEach>
            <br>
            <label style="font-weight: bold">Status: </label>
            <select name="statusUpdateUser" class="form-control">
                <c:set var="status" value="${requestScope.getUserUpdate.status}"/>
                <c:forEach var="item" items="${requestScope.enumUpdateUser}">
                    <c:set var="statusEnum" value="${item.value}"/>
                    <option value="${statusEnum}" ${status == statusEnum ? "selected" : ""}>
                            ${item.key}
                    </option>
                </c:forEach>
            </select>
            <br>
            <div class="row" style="margin-top: 30px">
                <div class="col-md-6">
                    <button value="Save" type="submit" class="btn btn-outline-primary" style="width: 110px">Save
                    </button>
                </div>
                <div class="col-md-6" style="align-self: center; text-align-last: end">
                    <c:url var="listUserUrl" value="/admin/users"/>
                    <a href="${listUserUrl}">
                        <button type="button" class="btn btn-outline-dark">Back to list</button>
                    </a>

                </div>
            </div>
        </form>
    </div>
    <div class="col-md-4"></div>
</div>

