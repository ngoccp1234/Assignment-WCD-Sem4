<%@ include file="../../taglibs/taglib.jsp" %>

<!--================Categories Banner Area =================-->
<section class="categories_banner_area">
    <div class="container">
        <div class="c_banner_inner">
            <h3>List All Product Page</h3>
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">Products</a></li>
                <li class="current"><a href="#">List All Product</a></li>
            </ul>
        </div>
    </div>
</section>
<!--================End Categories Banner Area =================-->

<!--================Categories Product Area =================-->
<section class="categories_product_main p_80">
    <div class="container">
        <div class="categories_main_inner">
            <div class="row row_disable">
                <div class="col-lg-9 float-md-right">
                    <div class="showing_fillter">
                        <div class="row m0">
                            <div class="first_fillter">
                                <h4>Showing 1 to 12 of 30 total</h4>
                            </div>
                            <div class="secand_fillter">
                                <h4>SORT BY :</h4>
                                <select class="selectpicker">
                                    <option>Name</option>
                                    <option>Name 2</option>
                                    <option>Name 3</option>
                                </select>
                            </div>
                            <div class="third_fillter">
                                <h4>Show : </h4>
                                <select class="selectpicker">
                                    <option>09</option>
                                    <option>10</option>
                                    <option>10</option>
                                </select>
                            </div>
                            <div class="four_fillter">
                                <h4>View</h4>
                                <a class="active" href="#"><i class="icon_grid-2x2"></i></a>
                                <a href="#"><i class="icon_grid-3x3"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="categories_product_area">
                        <div class="row">
                            <c:forEach var="item" items="${requestScope.getAllProductList}">
                                <div class="col-lg-4 col-sm-6">
                                    <div class="l_product_item">
                                        <div class="l_p_img">
                                            <c:url var="urlProduct" value="/product">
                                                <c:param name="id" value="${item.id}"/>
                                            </c:url>
                                            <a href="${urlProduct}"><img src="${item.image}" alt="image cream"  style="height: 317px; width: 100% !important; " onerror="this.onerror=null; this.src='https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRkLAoS7su3_GHk-dy2O1yhOO7vUGPcazX5YA&usqp=CAU'" /></a>
                                        </div>
                                        <div class="l_p_text">
                                            <ul>
                                                <li class="p_icon"><a href="#" style="padding-top: 27%"><i class="icon_piechart"></i></a></li>
                                                <li><a class="add_cart_btn" href="${urlProduct}">Detail</a></li>
                                                <li class="p_icon"><a href="#" style="padding-top: 27%"><i class="icon_heart_alt"></i></a></li>
                                            </ul>

                                            <h4>${item.name}</h4>
                                            <h5>${item.price}</h5>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>

                        </div>
                        <nav aria-label="Page navigation example" class="pagination_area">
                            <ul class="pagination">
                                <li class="page-item"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item"><a class="page-link" href="#">4</a></li>
                                <li class="page-item"><a class="page-link" href="#">5</a></li>
                                <li class="page-item"><a class="page-link" href="#">6</a></li>
                                <li class="page-item next"><a class="page-link" href="#"><i class="fa fa-angle-right"
                                                                                            aria-hidden="true"></i></a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <div class="col-lg-3 float-md-right">
                    <div class="categories_sidebar">
                        <aside class="l_widgest l_p_categories_widget">
                            <div class="l_w_title">
                                <h3>Categories</h3>
                            </div>
                            <ul class="navbar-nav">
                                <c:forEach var="ct" items="${sessionScope.categoriesClient}">
                                <c:url var="productsURL" value="/products">
                                    <c:param name="id" value="${ct.id}"/>
                                </c:url>
                                <li class="nav-item">
                                    <a class="nav-link" href="${productsURL}">${ct.name}
                                        <i class="icon_plus" aria-hidden="true"></i>
                                        <i class="icon_minus-06" aria-hidden="true"></i>
                                    </a>
                                </li>
                                </c:forEach>

                        </aside>
                        <aside class="l_widgest l_fillter_widget">
                            <div class="l_w_title">
                                <h3>Filter section</h3>
                            </div>
                            <div id="slider-range" class="ui_slider"></div>
                            <label for="amount">Price:</label>
                            <input type="text" id="amount" readonly>
                        </aside>
                        <aside class="l_widgest l_color_widget">
                            <div class="l_w_title">
                                <h3>Smell</h3>
                            </div>
                            <ul style="margin-left: 22px">

                                <li>
                                    <c:forEach var="attr" items="${requestScope.attrProducts}">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" name="attributeId" value="${attr.id}" id="defaultCheck1">
                                            <label class="form-check-label" for="defaultCheck1">
                                                    ${attr.name}
                                            </label>
                                        </div>
                                    </c:forEach>
                                </li>
                            </ul>
                        </aside>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================End Categories Product Area =================-->

