<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@include file="../../../taglibs/taglib.jsp"%>
<%
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>) request.getAttribute("errorsP");
%>
<h1 class="text-center" style="margin: 70px 0">Form Add Product</h1>
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
        <form action="/admin/product/add" method="post">
            <label style="font-weight: bold">Name: </label>
            <input type="text" name="nameProduct" width="200px" class="form-control"
                   placeholder="Please enter name product.">
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
            <select class="form-control" name="categoryProduct">
                <c:forEach var="item" items="${sessionScope.getCategories}">
                    <option value="${item.id}">${item.name}</option>
                </c:forEach>
            </select>
            <br>
            <label style="font-weight: bold">Image Link: </label>
            <input type="text" name="imageProduct" width="200px" class="form-control"
                   placeholder="Please enter link image product.">
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
            <input type="number" name="priceProduct" width="200px" class="form-control"
                   placeholder="Please enter price product.">
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
            <input type="number" name="quantityProduct" width="200px" class="form-control"
                   placeholder="Please enter quantity product.">
            <%
                if (errors != null && errors.containsKey("quantity")) {
            %>
            <p class="error">* <%=errors.get("quantity").get(0)%>
            </p>
            <%
                }
            %>
            <br>
            <label style="font-weight: bold">Description: </label>
            <textarea class="form-control" rows="5" name="descriptionProduct"></textarea>
            <%
                if (errors != null && errors.containsKey("description")) {
            %>
            <p class="error">* <%=errors.get("description").get(0)%>
            </p>
            <%
                }
            %>

            <label  style="font-weight: bold">Status: </label>
            <select name="statusProduct"  class="form-control">
                <c:forEach var="item" items="${sessionScope.enumProduct}">
                    <option value="${item.value}">${item.key}</option>
                </c:forEach>
            </select>
            <br>
            <div class="row" style="margin-top: 30px">
                <div class="col-md-6">
                    <button value="Submit" type="submit" class="btn btn-outline-primary" style="width: 110px">Submit</button>
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