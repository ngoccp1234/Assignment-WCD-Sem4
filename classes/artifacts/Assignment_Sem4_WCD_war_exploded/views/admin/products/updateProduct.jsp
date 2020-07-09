<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@include file="../../../taglibs/taglib.jsp" %>
<%
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>) request.getAttribute("errorsP");
%>
<h1 class="text-center" style="margin: 70px 0">Form Update Product</h1>
<br>
<%--<c:url var="listPUrl" value="/admin-listProduct"/>--%>
<%--<h6 class="m-0 font-weight-bold text-primary"><a href="${listPUrl}">List Product</a></h6>--%>
<%--<br>--%>
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
        <form action="/admin/product/update" method="post">
            <input type="hidden" name="idUpdateProduct" value="${sessionScope.getProductUpdate.id}">
            <label style="font-weight: bold">Name: </label>
            <input type="text" name="nameUpdateProduct" width="200px" class="form-control"
                   placeholder="Please enter name product." value="${sessionScope.getProductUpdate.name}">
            <%
                if (errors != null && errors.containsKey("name")) {
            %>
            <p class="error">* <%=errors.get("name").get(0)%>
            </p>
            <%
                }
            %>
            <br>
            <label style="font-weight: bold">Category: </label>
            <select class="form-control" name="categoryUpdateProduct">
                <c:forEach var="item" items="${sessionScope.getCategoriesUpdate}">
                    <option value="${item.id}" ${sessionScope.getProductUpdate.category_id == item.id ? "selected" : ""}>
                            ${item.name}
                    </option>
                </c:forEach>
            </select>

            <br>
            <label style="font-weight: bold">Image Link: </label>
            <input type="text" name="imageUpdateProduct" width="200px" class="form-control"
                   placeholder="Please enter link image product." value="${sessionScope.getProductUpdate.image}">
            <%
                if (errors != null && errors.containsKey("image")) {
            %>
            <p class="error">* <%=errors.get("image").get(0)%>
            </p>
            <%
                }
            %>
            <br>
            <label style="font-weight: bold">Price: </label>
            <input type="number" name="priceUpdateProduct" width="200px" class="form-control"
                   placeholder="Please enter price product." value="${sessionScope.getProductUpdate.price}">
            <%
                if (errors != null && errors.containsKey("price")) {
            %>
            <p class="error">* <%=errors.get("price").get(0)%>
            </p>
            <%
                }
            %>
            <br>
            <label style="font-weight: bold">Quantity: </label>
            <input type="number" name="quantityUpdateProduct" width="200px" class="form-control"
                   placeholder="Please enter quantity product." value="${sessionScope.getProductUpdate.quantity}">
            <%
                if (errors != null && errors.containsKey("quantity")) {
            %>
            <p class="error">* <%=errors.get("quantity").get(0)%>
            </p>
            <%
                }
            %>
            <br>
            <label style="font-weight: bold">Smell: </label>
            <c:forEach var="attr" items="${sessionScope.getAttributesUpdate}">
                <c:forEach var="idAttr" items="${sessionScope.getProductUpdate.attributes}">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" name="attributeUpdate"
                               value="${attr.id}" ${idAttr.id == attr.id ? "checked" : ""} id="defaultCheck3">
                        <label class="form-check-label">
                                ${attr.name}
                        </label>
                    </div>
                </c:forEach>
            </c:forEach>

            <br>
            <label style="font-weight: bold">Description: </label>
            <textarea class="form-control" rows="5" name="descriptionUpdateProduct"
                      >${sessionScope.getProductUpdate.description}
            </textarea>
            <%
                if (errors != null && errors.containsKey("description")) {
            %>
            <p class="error">* <%=errors.get("description").get(0)%>
            </p>
            <%
                }
            %>
            <label style="font-weight: bold">Status: </label>
            <select name="statusUpdateProduct" class="form-control">
                <c:set var="status" value="${sessionScope.getProductUpdate.status}"/>
                <c:forEach var="item" items="${sessionScope.enumUpdateProduct}">
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
                    <c:url var="listPUrl" value="/admin/products"/>
                    <a href="${listPUrl}"><button type="button" class="btn btn-outline-dark">Back to list</button></a>

                </div>
            </div>
        </form>
    </div>
    <div class="col-md-4"></div>
</div>
