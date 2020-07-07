package com.assignment.controllerAdmin.user;

import com.assignment.dao.RoleDAO;
import com.assignment.dao.UserDAO;
import com.assignment.model.Enum.EnumUser;
import com.assignment.model.User;
import com.assignment.model.User_Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    UserDAO userDAO = new UserDAO();
    RoleDAO roleDAO = new RoleDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idUpdateUser"));
        String name = request.getParameter("nameUpdateUser");
        String email = request.getParameter("emailUpdateUser");
        String phone = request.getParameter("phoneUpdateUser");
        String username = request.getParameter("usernameUpdateUser");
        String password = request.getParameter("passwordUpdateUser");
        int status = Integer.parseInt(request.getParameter("statusUpdateUser"));
        String[]roles = request.getParameterValues("roleUpdateUser");
        User user = new User(id, name, email, phone, username, password, status);
        userDAO.updateUser(user);
        if (roles != null && roles.length > 0)
        {
            for (String idRole : roles)
            {
                User_Role user_role = new User_Role();
                user_role.setRoleId(Integer.parseInt(idRole));
                user_role.setUserId(user.getId());
//                userDAO.updateUserRole(user_role);
            }
            response.sendRedirect("/admin/users");
        }else
        {
            response.sendRedirect("/admin/error");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null && id.length() > 0)
        {
            request.setAttribute("getAllRole", roleDAO.getAllRole());
            request.setAttribute("enumUpdateUser", EnumUser.values());
            request.setAttribute("getUserUpdate", userDAO.getUser(Integer.parseInt(id)));
            request.getRequestDispatcher("/views/admin/users/updateUser.jsp").forward(request, response);
        }else
        {
            response.sendRedirect("/admin/error");
        }

    }
}
