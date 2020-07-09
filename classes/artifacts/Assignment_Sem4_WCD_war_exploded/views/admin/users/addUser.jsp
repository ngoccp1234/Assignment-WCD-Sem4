<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@include file="../../../taglibs/taglib.jsp"%>
<%
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>) request.getAttribute("errorsU");

%>
<h1 class="text-center" style="margin: 70px 0">Form Add User</h1>
<br>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4 form-group">
        <%
            if (errors != null && errors.size() > 0) {
        %>
        <span class="error">Please fix errors below and try again!</span>
        <%
            }
        %>
        <form action="/admin/user/add" method="post">
            <label  style="font-weight: bold">Name: </label>
            <input type="text" name="nameUser" width="200px" class="form-control"
                   placeholder="Please enter name for user.">
            <%
                if (errors != null && errors.containsKey("name")) {
            %>
            <p class="error">* <%=errors.get("name").get(0)%>
            </p>
            <%
                }
            %>
            <br>
            <label  style="font-weight: bold">Email: </label>
            <input type="email" name="emailUser" width="200px" class="form-control"
                   placeholder="Please enter email for user.">
            <%
                if (errors != null && errors.containsKey("email")) {
            %>
            <p class="error">* <%=errors.get("email").get(0)%>
            </p>
            <%
                }
            %>
            <br>
            <label  style="font-weight: bold">Phone: </label>
            <input type="number" name="phoneUser" width="200px" class="form-control"
                   placeholder="Please enter phone for user.">
            <%
                if (errors != null && errors.containsKey("phone")) {
            %>
            <p class="error">* <%=errors.get("phone").get(0)%>
            </p>
            <%
                }
            %>
            <br>
            <label  style="font-weight: bold">Username: </label>
            <input type="text" name="usernameUser" width="200px" class="form-control"
                   placeholder="Please enter username for user.">
            <%
                if (errors != null && errors.containsKey("username")) {
            %>
            <p class="error">* <%=errors.get("username").get(0)%>
            </p>
            <%
                }
            %>
            <br>
            <label  style="font-weight: bold">Password: </label>
            <input type="password" name="passwordUser" width="200px" class="form-control"
                   placeholder="Please enter password for user.">
            <%
                if (errors != null && errors.containsKey("password")) {
            %>
            <p class="error">* <%=errors.get("password").get(0)%>
            </p>
            <%
                }
            %>
            <br>
            <label  style="font-weight: bold">Role: </label>
            <c:forEach var="item" items="${sessionScope.getRoles}">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="rolesUser" value="${item.id}" id="defaultCheck1">
                    <label class="form-check-label" for="defaultCheck1">
                            ${item.name}
                    </label>
                </div>
            </c:forEach>
            <br>
            <label  style="font-weight: bold">Status: </label>
            <select name="statusUser" class="form-control">
                <c:forEach var="item" items="${sessionScope.enumUser}">
                    <option value="${item.value}">${item.key}</option>
                </c:forEach>
            </select>
            <br>
            <div class="row">
                <div class="col-md-6">
                    <button value="Submit" type="submit" class="btn btn-outline-primary" style="width: 110px">Submit</button>
                </div>
                <div class="col-md-6" style="align-self: center; text-align-last: end">
                    <c:url var="listUserUrl" value="/admin/users"/>
                    <a href="${listUserUrl}"><button type="button" class="btn btn-outline-dark">Back to list</button></a>
                </div>
            </div>
        </form>
    </div>
    <div class="col-md-4"></div>
</div>