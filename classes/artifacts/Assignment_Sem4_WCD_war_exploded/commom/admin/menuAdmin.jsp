<%@include file="../../taglibs/taglib.jsp"%>

<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <c:url var="URLHomeAdmin" value="/admin"/>
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${URLHomeAdmin}">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
        <a class="nav-link" href="${URLHomeAdmin}">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
        Admin Manager
    </div>

    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
            <i class="fas fa-align-justify"></i></i>
            <span>Categories</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Manager Category:</h6>
                <c:url var="urlAddCt" value="/admin/category/add"/>
                <c:url var="urlListCt" value="/admin/categories"/>
                <a class="collapse-item" href="${urlAddCt}">Add Category</a>
                <a class="collapse-item" href="${urlListCt}">List Category</a>
            </div>
        </div>
    </li>

    <!-- Nav Item - Utilities Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fas fa-ice-cream"></i>
            <span>Products</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Manager Product:</h6>
                <c:url var="urlAddP" value="/admin/product/add"/>
                <c:url var="urlListP" value="/admin/products"/>
                <a class="collapse-item" href="${urlAddP}">Add Product</a>
                <a class="collapse-item" href="${urlListP}">List Product</a>

            </div>
        </div>
    </li>

    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities2" aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fas fa-user-tag"></i>
            <span>Roles</span>
        </a>
        <div id="collapseUtilities2" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Manager Role:</h6>
                <c:url var="urlAddRole" value="/admin/role/add"/>
                <c:url var="urlListRole" value="/admin/roles"/>
                <a class="collapse-item" href="${urlAddRole}">Add Role</a>
                <a class="collapse-item" href="${urlListRole}">List Role</a>

            </div>
        </div>
    </li>

    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities3" aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fas fa-user"></i></i>
            <span>Users</span>
        </a>
        <div id="collapseUtilities3" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Manager User:</h6>
                <c:url var="urlAddUser" value="/admin/user/add"/>
                <c:url var="urlListUser" value="/admin/users"/>
                <a class="collapse-item" href="${urlAddUser}">Add User</a>
                <a class="collapse-item" href="${urlListUser}">List User</a>

            </div>
        </div>
    </li>
    <!-- Divider -->
    <%--    <hr class="sidebar-divider">--%>

    <%--    <!-- Heading -->--%>
    <%--    <div class="sidebar-heading">--%>
    <%--        Addons--%>
    <%--    </div>--%>

    <%--    <!-- Nav Item - Pages Collapse Menu -->--%>
    <%--    <li class="nav-item">--%>
    <%--        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">--%>
    <%--            <i class="fas fa-fw fa-folder"></i>--%>
    <%--            <span>Pages</span>--%>
    <%--        </a>--%>
    <%--        <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">--%>
    <%--            <div class="bg-white py-2 collapse-inner rounded">--%>
    <%--                <h6 class="collapse-header">Login Screens:</h6>--%>
    <%--                <a class="collapse-item" href="login.html">Login</a>--%>
    <%--                <a class="collapse-item" href="register.html">Register</a>--%>
    <%--                <a class="collapse-item" href="forgot-password.html">Forgot Password</a>--%>
    <%--                <div class="collapse-divider"></div>--%>
    <%--                <h6 class="collapse-header">Other Pages:</h6>--%>
    <%--                <a class="collapse-item" href="404.html">404 Page</a>--%>
    <%--                <a class="collapse-item" href="blank.html">Blank Page</a>--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--    </li>--%>

    <%--    <!-- Nav Item - Charts -->--%>
    <%--    <li class="nav-item">--%>
    <%--        <a class="nav-link" href="charts.html">--%>
    <%--            <i class="fas fa-fw fa-chart-area"></i>--%>
    <%--            <span>Charts</span></a>--%>
    <%--    </li>--%>

    <%--    <!-- Nav Item - Tables -->--%>
    <%--    <li class="nav-item">--%>
    <%--        <a class="nav-link" href="tables.html">--%>
    <%--            <i class="fas fa-fw fa-table"></i>--%>
    <%--            <span>Tables</span></a>--%>
    <%--    </li>--%>

    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

</ul>