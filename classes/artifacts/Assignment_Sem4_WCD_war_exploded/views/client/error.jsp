<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="categories_banner_area">
    <div class="container">
        <div class="c_banner_inner">
            <h3>Error Page</h3>
            <ul>
                <c:url var="urlHome" value="/home"/>
                <li><a href="${urlHome}">Home</a></li>
                <li class="current">Error</li>
            </ul>
        </div>
    </div>
</section>
<!--================End Categories Banner Area =================-->
<section class="error_area p_100">
    <div class="container">
        <div class="error_inner">
            <h4>404</h4>
            <h5>Error - Not Found</h5>
            <p>Sorry We’re not able to find what you looking for</p>

            <h6>back to <a href="<c:url value='home'/>">Home</a></h6>
        </div>
    </div>
</section>