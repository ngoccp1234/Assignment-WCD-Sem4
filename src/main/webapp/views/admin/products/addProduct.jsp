<%@include file="../../../taglibs/taglib.jsp"%>
<h1 class="text-center" style="margin: 70px 0">Form Add Product</h1>
<br>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4 form-group">
        <form action="/admin/product/add" method="post">
            <label style="font-weight: bold">Name: </label>
            <input type="text" name="nameProduct" width="200px" class="form-control" required
                   placeholder="Please enter name product.">
            <br>
            <label style="font-weight: bold">Category: </label>
            <select class="form-control" name="categoryProduct">
                <c:forEach var="item" items="${requestScope.getCategories}">
                    <option value="${item.id}">${item.name}</option>
                </c:forEach>
            </select>
            <br>
            <label style="font-weight: bold">Image Link: </label>
            <input type="text" name="imageProduct" width="200px" class="form-control" required
                   placeholder="Please enter link image product.">
            <br>
            <label style="font-weight: bold">Price: </label>
            <input type="number" name="priceProduct" width="200px" class="form-control" required
                   placeholder="Please enter price product.">
            <br>
            <label style="font-weight: bold">Quantity: </label>
            <input type="number" name="quantityProduct" width="200px" class="form-control" required
                   placeholder="Please enter quantity product.">
            <br>
            <label style="font-weight: bold">Smell: </label>
            <c:forEach var="attr" items="${requestScope.attributeList}">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="attributeId" value="${attr.id}" id="defaultCheck1">
                    <label class="form-check-label" for="defaultCheck1">
                            ${attr.name}
                    </label>
                </div>
            </c:forEach>


            <br>
            <label style="font-weight: bold">Description: </label>
            <textarea class="form-control" rows="5" name="descriptionProduct" required></textarea>

            <label  style="font-weight: bold">Status: </label>
            <select name="statusProduct"  class="form-control">
                <c:forEach var="item" items="${requestScope.enumProduct}">
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