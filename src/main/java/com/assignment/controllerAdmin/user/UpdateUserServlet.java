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
import java.io.PrintWriter;

@WebServlet(name = "UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    UserDAO userDAO = new UserDAO();
    RoleDAO roleDAO = new RoleDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("err.jsp");
        PrintWriter pw = response.getWriter();
        int id = Integer.parseInt(request.getParameter("idUpdateUser"));
        String name = request.getParameter("nameUpdateUser");
        String email = request.getParameter("emailUpdateUser");
        String phone = request.getParameter("phoneUpdateUser");
        String username = request.getParameter("usernameUpdateUser");
        String password = request.getParameter("passwordUpdateUser");
        int status = Integer.parseInt(request.getParameter("statusUpdateUser"));
        String[] roles = request.getParameterValues("roleUpdateUser");
        if ((name == null) || (name.equals(""))) {
            pw.write("PROVIDE USER NAME...");
        } else if ((email == null) || (email.equals(""))) {
            pw.write("PROVIDE USER EMAIL...");
        } else if ((phone == null) || (phone.equals(""))) {
            pw.write("PROVIDE USER PHONE...");
        } else if ((username == null) || (username.equals(""))) {
            pw.write("PROVIDE USER USERNAME...");
        } else if ((password == null) || (password.equals(""))) {
            pw.write("PROVIDE USER PASSWORD...");
        } else if ((String.valueOf(status) == null) || (String.valueOf(status).equals(""))) {
            pw.write("PROVIDE USER STATUS...");
        } else if ((name.length() <= 5) || (name.length() >= 50)) {
            pw.write("NAME >= 5 AND <= 50");
        } else if ((phone.length() <= 10) || (name.length() >= 11)) {
            pw.write("PHONE >= 10 AND <= 11");
        } else if ((username.length() <= 5) || (username.length() >= 50)) {
            pw.write("USERNAME >= 5 AND <= 50");
        } else if ((password.length() <= 5) || (password.length() >= 50)) {
            pw.write("PASSWORD >= 5 AND <= 50");
        } else {
            User user = new User(id, name, email, phone, username, password, status);
            userDAO.updateUser(user);
            if (roles != null && roles.length > 0) {
                for (String idRole : roles) {
                    User_Role user_role = new User_Role();
                    user_role.setRoleId(Integer.parseInt(idRole));
                    user_role.setUserId(user.getId());
//                userDAO.updateUserRole(user_role);
                }
                response.sendRedirect("/admin/users");
            } else {
                response.sendRedirect("/admin/error");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null && id.length() > 0) {
            request.setAttribute("getAllRole", roleDAO.getAllRole());
            request.setAttribute("enumUpdateUser", EnumUser.values());
            request.setAttribute("getUserUpdate", userDAO.getUser(Integer.parseInt(id)));
            request.getRequestDispatcher("/views/admin/users/updateUser.jsp").forward(request, response);
        } else {
            response.sendRedirect("/admin/error");
        }

    }
}
