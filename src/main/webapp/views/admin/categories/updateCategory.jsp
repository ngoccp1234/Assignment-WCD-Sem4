<%@include file="../../../taglibs/taglib.jsp" %>
<h1 class="text-center" style="margin: 70px 0">Form Update Category</h1>
<br>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4 form-group">
        <form action="/admin/category/update" method="post">
            <input type="hidden" name="idUpdateCt" value="${requestScope.getCategory.id}">
            <label style="font-weight: bold">Name: </label>
            <input type="text" name="nameUpdateCt" value="${requestScope.getCategory.name}"
                   width="200px" class="form-control" required
            >
            <br>
            <label style="font-weight: bold">Image link: </label>
            <input type="text" name="imageUpdateCt" value="${requestScope.getCategory.image}"
                   width="200px" class="form-control" required>
            <br>
            <label style="font-weight: bold">Description: </label>
            <textarea class="form-control" rows="5" name="descriptionUpdateCt"
                      required>${requestScope.getCategory.description}
            </textarea>
            <br>
            <label style="font-weight: bold">Status: </label>
            <select name="statusUpdateCt" class="form-control">
                <c:set var="status" value="${requestScope.getCategory.status}"/>
                <%--                <option value="${requestScope.getCategory.status}" selected>${requestScope.getCategory.status}</option>--%>
                <c:forEach var="item" items="${requestScope.enumUpdateCt}">
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
