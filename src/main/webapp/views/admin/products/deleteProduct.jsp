<%@ include file="../../../taglibs/taglib.jsp" %>
<h1 class="text-center" style="margin: 70px 0">Delete Product</h1>
<br>

<div class="card" style="width: 30rem; margin: 0 10% 15% 31%">
    <img class="card-img-top" src="${requestScope.getProductDelete.image}" alt="Card image cap">
    <ul class="list-group list-group-flush" style="font-size: 24px">
        <li class="list-group-item"><b>Id:</b> ${requestScope.getProductDelete.id}</li>
        <li class="list-group-item"><b>Name:</b> ${requestScope.getProductDelete.name}</li>
        <li class="list-group-item"><b>Category:</b> ${requestScope.getProductDelete.category.name}</li>
        <li class="list-group-item"><b>Price:</b> ${requestScope.getProductDelete.price}</li>
        <li class="list-group-item"><b>Quantity:</b> ${requestScope.getProductDelete.quantity}</li>
        <li class="list-group-item"><b>Description:</b> ${requestScope.getProductDelete.description}</li>

        <li class="list-group-item"><b>Status:</b><c:set var="status" value="${requestScope.getProductDelete.status}"/>
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
            </c:choose></li>
    </ul>
    <div class="card-body">
        <form action="/admin/product/delete" method="post">
            <input type="hidden" value="${requestScope.getProductDelete.id}" name="idPDelete">
            <c:url var="listPUrl" value="/admin/products"/>
            <div class="row" style="text-align-last: center">
                <div class="col-md-6" style="padding-top: 15px">
                    <button value="Delete" class="btn btn-outline-danger btn-lg" type="submit" style="width: 130px">Delete</button>
                </div>
                <div class="col-md-6" style="text-align: end; padding-top: 15px">
                    <a href="${listPUrl}" class="card-link">
                        <button class="btn btn-outline-dark btn-lg" type="button">Back to list</button>
                    </a>
                </div>
            </div>

        </form>
    </div>
</div>




