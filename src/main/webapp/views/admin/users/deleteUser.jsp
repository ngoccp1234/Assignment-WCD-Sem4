<%@ include file="../../../taglibs/taglib.jsp" %>
<h1 class="text-center" style="margin: 70px 0">Delete User</h1>
<br>


<div class="card" style="width: 30rem; margin: 0 10% 15% 31%">
    <img class="card-img-top" src="https://www.awesomegreece.com/wp-content/uploads/2018/10/default-user-image.png"
         alt="Card image cap">
    <ul class="list-group list-group-flush" style="font-size: 24px">
        <li class="list-group-item"><b>Id:</b> ${requestScope.getUserDelete.id}</li>
        <li class="list-group-item"><b>Name:</b> ${requestScope.getUserDelete.name}</li>
        <li class="list-group-item"><b>Email:</b> ${requestScope.getUserDelete.email}</li>
        <li class="list-group-item"><b>Phone:</b> ${requestScope.getUserDelete.phone}</li>
        <li class="list-group-item"><b>Username:</b> ${requestScope.getUserDelete.username}</li>
        <li class="list-group-item"><b>Role:</b>
            <c:forEach var="role" items="${requestScope.getUserDelete.user_roles}">
                ${role.role.name},
            </c:forEach></li>

        <li class="list-group-item"><b>Status:</b><c:set var="status" value="${requestScope.getUserDelete.status}"/>
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
        <form action="/admin/user/delete" method="post">
            <input type="hidden" value="${requestScope.getUserDelete.id}" name="idUserDelete">
            <c:url var="listUserUrl" value="/admin/users"/>
            <div class="row" style="text-align-last: center">
                <div class="col-md-6" style="padding-top: 15px">
                    <button value="Delete" class="btn btn-outline-danger btn-lg" type="submit" style="width: 130px">
                        Delete
                    </button>
                </div>
                <div class="col-md-6" style="text-align: end; padding-top: 15px">
                    <a href="${listUserUrl}" class="card-link">
                        <button class="btn btn-outline-dark btn-lg" type="button">Back to list</button>
                    </a>
                </div>
            </div>

        </form>
    </div>
</div>



