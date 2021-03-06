package com.assignment.controllerAdmin.user;

import com.assignment.dao.RoleDAO;
import com.assignment.dao.UserDAO;
import com.assignment.model.Enum.EnumRole;
import com.assignment.model.Enum.EnumUser;
import com.assignment.model.Role;
import com.assignment.model.User;
import com.assignment.model.User_Role;
import com.assignment.model.validate.ProductForm;
import com.assignment.model.validate.UserForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddUserServlet")
public class AddUserServlet extends HttpServlet {
    RoleDAO roleDAO = new RoleDAO();
    UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameUser");
        String email = request.getParameter("emailUser");
        String phone = request.getParameter("phoneUser");
        String username = request.getParameter("usernameUser");
        String password = request.getParameter("passwordUser");
        String status = request.getParameter("statusUser");
        String[] roles = request.getParameterValues("rolesUser");
        UserForm userForm = new UserForm(name, email, password, phone, username);
        if (userForm.getErrors().size() > 0) {
            request.setAttribute("errorsU", userForm.getErrors());
            request.getRequestDispatcher("/views/admin/users/addUser.jsp").forward(request, response);
        } else {
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPhone(phone);
            user.setUsername(username);
            user.setPassword(password);
            user.setStatus(Integer.parseInt(status));
            userDAO.insertUser(user);

            if (roles != null && roles.length > 0) {
//            List<Role> list = new ArrayList<Role>();
                for (String idRole : roles) {
                    User_Role user_role = new User_Role();
                    user_role.setRoleId(Integer.parseInt(idRole));
                    user_role.setUserId(user.getId());
//                user_role.setRoleId(roles);
                    userDAO.insertUserRole(user_role);
//                list.add(user_role);
                }
//            user.setUser_roles(list);
                response.sendRedirect("/admin/users");
            } else {
                response.sendRedirect("/admin/error");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("getRoles", roleDAO.getAllRole());
        session.setAttribute("enumUser", EnumUser.values());
        request.getRequestDispatcher("/views/admin/users/addUser.jsp").forward(request, response);
    }
}
