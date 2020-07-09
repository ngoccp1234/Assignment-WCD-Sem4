<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@include file="../../../taglibs/taglib.jsp" %>

<%
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>) request.getAttribute("errors");

%>
<h1 class="text-center" style="margin: 70px 0">Form Update Category</h1>
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
        <form action="/admin/category/update" method="post">
            <input type="hidden" name="idUpdateCt" value="${sessionScope.getCategory.id}">
            <label style="font-weight: bold">Name: </label>
            <input type="text" name="nameUpdateCt" value="${sessionScope.getCategory.name}"
                   width="200px" class="form-control"
            >
            <%
                if (errors != null && errors.containsKey("name")) {
            %>
            <p class="error">* <%=errors.get("name").get(0)%>
            </p>
            <%
                }
            %>
            <br>
            <label style="font-weight: bold">Image link: </label>
            <input type="text" name="imageUpdateCt" value="${sessionScope.getCategory.image}"
                   width="200px" class="form-control" >
            <%
                if (errors != null && errors.containsKey("image")) {
            %>
            <p class="error">* <%=errors.get("image").get(0)%>
            </p>
            <%
                }
            %>
            <br>
            <label style="font-weight: bold">Description: </label>
            <textarea class="form-control" rows="5" name="descriptionUpdateCt"
                      >${sessionScope.getCategory.description}
            </textarea>
            <%
                if (errors != null && errors.containsKey("description")) {
            %>
            <p class="error">* <%=errors.get("description").get(0)%>
            </p>
            <%
                }
            %>
            <br>
            <label style="font-weight: bold">Status: </label>
            <select name="statusUpdateCt" class="form-control">
                <c:set var="status" value="${sessionScope.getCategory.status}"/>
                <%--                <option value="${requestScope.getCategory.status}" selected>${requestScope.getCategory.status}</option>--%>
                <c:forEach var="item" items="${sessionScope.enumUpdateCt}">
                    <c:set var="statusEnum" value="${item.value}"/>
                    <option value="${statusEnum}" ${status == statusEnum ? "selected" : ""}>
                            ${item.key}
                            <%--                        <c:if test="${status == statusEnum}">--%>
                            <%--                            <c:choose>--%>
                            <%--                                <c:when test="${status == 1}">--%>
                            <%--                                    <c:out value="ACTIVE"/>--%>
                            <%--                                </c:when>--%>
                            <%--                                <c:when test="${status == 2}">--%>
                            <%--                                    <c:out value="DEACTIVATED"/>--%>
                            <%--                                </c:when>--%>
                            <%--                                <c:when test="${status == 3}">--%>
                            <%--                                    <c:out value="DELETED"/>--%>
                            <%--                                </c:when>--%>
                            <%--                                <c:otherwise>--%>
                            <%--                                    <c:out value="NULL"/>--%>
                            <%--                                </c:otherwise>--%>
                            <%--                            </c:choose>--%>
                            <%--                        </c:if>--%>

                    </option>
                </c:forEach>
            </select>
            <br>
            <div class="row" style="margin-top: 30px">
                <div class="col-md-6">
                    <button value="Save" type="submit" class="btn btn-outline-primary" style="width: 110px">Save</button>
                </div>
                <div class="col-md-6" style="align-self: center; text-align-last: end">
                    <c:url var="listCtUrl" value="/admin/categories"/>
                    <a href="${listCtUrl}"><button type="button" class="btn btn-outline-dark">Back to list</button></a>

                </div>
            </div>
        </form>
    </div>
    <div class="col-md-4"></div>
</div>
