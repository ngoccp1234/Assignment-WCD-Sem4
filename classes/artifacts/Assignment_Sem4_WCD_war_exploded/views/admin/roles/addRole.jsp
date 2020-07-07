<%@include file="../../../taglibs/taglib.jsp"%>
<h1 class="text-center" style="margin: 70px 0">Form Add Role</h1>
<br>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4 form-group">
        <form action="/admin/role/add" method="post">
            <label  style="font-weight: bold">Name: </label>
            <input type="text" name="nameRole" width="200px" class="form-control"
                   placeholder="Please enter name role.">
            <br>
            <label  style="font-weight: bold">Description: </label>
            <textarea class="form-control" rows="5" name="descriptionRole"   placeholder="Please enter link description role."></textarea>
            <br>
            <label  style="font-weight: bold">Status: </label>
            <select name="statusRole" class="form-control">
                <c:forEach var="item" items="${requestScope.enumRole}">
                    <option value="${item.value}">${item.key}</option>
                </c:forEach>
            </select>
            <br>
            <div class="row">
                <div class="col-md-6">
                    <button value="Submit" type="submit" class="btn btn-outline-primary" style="width: 110px">Submit</button>
                </div>
                <div class="col-md-6" style="align-self: center; text-align-last: end">
                    <c:url var="listRoleUrl" value="/admin/roles"/>
                    <a href="${listRoleUrl}"><button type="button" class="btn btn-outline-dark">Back to list</button></a>
                </div>
            </div>


        </form>
    </div>
    <div class="col-md-4"></div>
</div>