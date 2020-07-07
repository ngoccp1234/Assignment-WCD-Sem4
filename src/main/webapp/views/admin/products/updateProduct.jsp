<%@include file="../../../taglibs/taglib.jsp" %>
<h1 class="text-center" style="margin: 70px 0">Form Update Product</h1>
<br>
<%--<c:url var="listPUrl" value="/admin-listProduct"/>--%>
<%--<h6 class="m-0 font-weight-bold text-primary"><a href="${listPUrl}">List Product</a></h6>--%>
<%--<br>--%>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4 form-group">
        <form action="/admin/product/update" method="post">
            <input type="hidden" name="idUpdateProduct" value="${requestScope.getProductUpdate.id}">
            <label style="font-weight: bold">Name: </label>
            <input type="text" name="nameUpdateProduct" width="200px" class="form-control" required
                   placeholder="Please enter name product." value="${requestScope.getProductUpdate.name}">
            <br>
            <label style="font-weight: bold">Category: </label>
            <select class="form-control" name="categoryUpdateProduct">
                <c:forEach var="item" items="${requestScope.getCategoriesUpdate}">
                    <option value="${item.id}" ${requestScope.getProductUpdate.category_id == item.id ? "selected" : ""}>
                            ${item.name}
                    </option>
                </c:forEach>
            </select>

            <br>
            <label style="font-weight: bold">Image Link: </label>
            <input type="text" name="imageUpdateProduct" width="200px" class="form-control" required
                   placeholder="Please enter link image product." value="${requestScope.getProductUpdate.image}">
            <br>
            <label style="font-weight: bold">Price: </label>
            <input type="number" name="priceUpdateProduct" width="200px" class="form-control" required
                   placeholder="Please enter price product." value="${requestScope.getProductUpdate.price}">
            <br>
            <label style="font-weight: bold">Quantity: </label>
            <input type="number" name="quantityUpdateProduct" width="200px" class="form-control" required
                   placeholder="Please enter quantity product." value="${requestScope.getProductUpdate.quantity}">
            <br>
            <label style="font-weight: bold">Smell: </label>
            <c:forEach var="attr" items="${requestScope.getAttributesUpdate}">
                <c:forEach var="idAttr" items="${requestScope.getProductUpdate.attributes}">
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
                      required>${requestScope.getProductUpdate.name}
            </textarea>

            <label style="font-weight: bold">Status: </label>
            <select name="statusUpdateProduct" class="form-control">
                <c:set var="status" value="${requestScope.getProductUpdate.status}"/>
                <c:forEach var="item" items="${requestScope.enumUpdateProduct}">
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
