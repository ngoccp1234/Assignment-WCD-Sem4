<%@include file="../../taglibs/taglib.jsp"%>

<header class="shop_header_area carousel_menu_area">
    <div class="carousel_menu_inner">
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <c:url var="urlBrand" value="/home"/>
                <%--                <a class="navbar-brand" href="${urlBrand}" style="margin-bottom: 1%"><img src="<c:url value='/commom/client/assets/img/logo.png'/>" alt=""></a>--%>
                <a class="navbar-brand" href="${urlBrand}" style="margin-bottom: 1%"><img src="https://www.pngkey.com/png/full/431-4312944_artesana-logo-no-circle-vector-artesana-ice-cream.png" style="max-width: 200px; max-height: 90px; height: 90px; width: 132px" alt="logo ice cream"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>

                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto" style="margin-left: 6%">
                        <c:url var="urlHome" value="/home"/>
                        <li class="nav-item"><a class="nav-link" href="${urlHome}">Home</a></li>

                        <li class="nav-item dropdown submenu">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                <c:url var="categories" value='/products'/>
                                <a href="${categories}">Categories</a> <i class="fa fa-angle-down"
                                                                          aria-hidden="true"></i>
                            </a>
                            <ul class="dropdown-menu">
                                <c:forEach var="cate" items="${sessionScope.categoriesClient}">
                                    <c:url var="productsURL" value="/products">
                                        <c:param name="id" value="${cate.id}"/>
                                    </c:url>
                                    <li class="nav-item"><a class="nav-link" href="${productsURL}">${cate.name}</a></li>
                                </c:forEach>
                            </ul>
                        </li>
                        <c:url var="products" value='/products'/>
                        <li class="nav-item"><a class="nav-link" href="${products}">Products</a></li>
                        <c:url var="urlBlog" value="/blog"/>
                        <li class="nav-item"><a class="nav-link" href="${urlBlog}">Blog</a></li>
                        <c:url var="urlContact" value="/contact"/>
                        <li class="nav-item"><a class="nav-link" href="${urlContact}">Contact</a></li>
                    </ul>
                    <ul class="navbar-nav justify-content-end">
                        <li class="search_icon"><a href="#" style="border: none"><i
                                class="icon-magnifier icons"></i></a></li>
                        <li class="user_icon"><a href="#" style="border: none"><i class="icon-user icons"></i></a></li>
                        <li class="cart_cart"><a href="#" style="border: none"><i class="icon-handbag icons"></i></a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
</header>
<!--================End Menu Area =================-->



