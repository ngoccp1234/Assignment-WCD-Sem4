<%@ include file="../../../taglibs/taglib.jsp" %>
<h1 class="text-center" style="margin: 70px 0">Delete Category</h1>
<br>


<div class="card" style="width: 30rem; margin: 0 10% 15% 31%">
    <img class="card-img-top" src="${requestScope.getCTDelete.image}" alt="Card image cap">
    <ul class="list-group list-group-flush" style="font-size: 24px">
        <li class="list-group-item"><b>Id:</b> ${requestScope.getCTDelete.id}</li>
        <li class="list-group-item"><b>Name:</b> ${requestScope.getCTDelete.name}</li>
        <li class="list-group-item"><b>Description:</b> ${requestScope.getCTDelete.description}</li>

        <li class="list-group-item"><b>Status:</b><c:set var="status" value="${requestScope.getCTDelete.status}"/>
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
        <form action="/admin/category/delete" method="post">
            <input type="hidden" value="${requestScope.getCTDelete.id}" name="idCTDelete">
            <c:url var="listCtUrl" value="/admin/categories"/>
            <div class="row" style="text-align-last: center">
                <div class="col-md-6" style="padding-top: 15px">
                    <button value="Delete" class="btn btn-outline-danger btn-lg" type="submit" style="width: 130px">Delete</button>
                </div>
                <div class="col-md-6" style="text-align: end; padding-top: 15px">
                    <a href="${listCtUrl}" class="card-link">
                        <button class="btn btn-outline-dark btn-lg" type="button">Back to list</button>
                    </a>
                </div>
            </div>

        </form>
    </div>
</div>


