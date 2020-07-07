package com.assignment.controllerAdmin.role;

import com.assignment.dao.RoleDAO;
import com.assignment.model.Enum.EnumCategory;
import com.assignment.model.Enum.EnumRole;
import com.assignment.model.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddRoleServlet")
public class AddRoleServlet extends HttpServlet {
    RoleDAO dao = new RoleDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameRole");
        String description = request.getParameter("descriptionRole");
        String status = request.getParameter("statusRole");
        Role role = new Role();
        role.setName(name);
        role.setDescription(description);
        role.setStatus(Integer.parseInt(status));
        dao.insertRole(role);
        response.sendRedirect("/admin/roles");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("enumRole", EnumRole.values());
        request.getRequestDispatcher("/views/admin/roles/addRole.jsp").forward(request, response);
    }
}
