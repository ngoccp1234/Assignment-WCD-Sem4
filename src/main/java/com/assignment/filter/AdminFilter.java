package com.assignment.filter;

import com.assignment.dao.RoleDAO;
import com.assignment.dao.UserRoleDAO;
import com.assignment.model.Role;
import com.assignment.model.User;
import com.assignment.model.User_Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter")
public class AdminFilter implements Filter {
    UserRoleDAO userRoleDAO = new UserRoleDAO();
    RoleDAO roleDAO = new RoleDAO();

    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userid = Integer.parseInt(String.valueOf(user.getId()));
        User_Role user_role = userRoleDAO.getUserRole(userid);
        int idroleuser = user_role.getRoleId();
        Role role = roleDAO.getRoleforName("Admin");
        int idrole = role.getId();
        if (idrole != idroleuser) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.sendRedirect("/admin-login");
        } else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
