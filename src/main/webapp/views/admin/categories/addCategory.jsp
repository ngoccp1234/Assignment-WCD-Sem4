<%@include file="../../../taglibs/taglib.jsp" %>
<h1 class="text-center" style="margin: 70px 0">Form Add Category</h1>
<br>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4 form-group">
        <form action="/admin/category/add" method="post" id="AddCategory">
            <label style="font-weight: bold">Name: </label>
            <input type="text" name="nameCategory" width="200px" class="form-control" required
                   placeholder="Please enter name category.">
            <br>
            <label for="imageCategory" style="font-weight: bold">Image link: </label>
            <input type="text" name="imageCategory" id="imageCategory" width="200px" class="form-control" required
                   placeholder="Please enter link image category.">
            <br>
            <label style="font-weight: bold">Description: </label>
            <textarea class="form-control" rows="5" name="descriptionCategory" required
                      placeholder="Please enter link description category."></textarea>
            <br>
            <label style="font-weight: bold">Status: </label>
            <select name="statusCategory" class="form-control">
                <c:forEach var="item" items="${requestScope.enumCategory}">
                    <option value="${item.value}">${item.key}</option>
                </c:forEach>
            </select>
            <br>
            <div class="row">
                <div class="col-md-6">
                    <button value="Submit" type="submit" class="btn btn-outline-primary" style="width: 110px">Submit
                    </button>
                </div>
                <div class="col-md-6" style="align-self: center; text-align-last: end">
                    <c:url var="listCtUrl" value="/admin/categories"/>
                    <a href="${listCtUrl}">
                        <button type="button" class="btn btn-outline-dark">Back to list</button>
                    </a>
                </div>
            </div>


        </form>
    </div>
    <div class="col-md-4"></div>
</div>
