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
import java.io.PrintWriter;

@WebServlet(name = "AddRoleServlet")
public class AddRoleServlet extends HttpServlet {
    RoleDAO dao = new RoleDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("err.jsp");
        PrintWriter pw = response.getWriter();
        String name = request.getParameter("nameRole");
        String description = request.getParameter("descriptionRole");
        String status = request.getParameter("statusRole");
        if ((name == null) || (name.equals(""))) {
            pw.write("PROVIDE ROLE NAME...");
        } else if ((description == null) || (description.equals(""))) {
            pw.write("PROVIDE DESCRIPTION...");
        } else if ((status == null) || (status.equals(""))) {
            pw.write("PROVIDE STATUS...");
        } else {
            Role role = new Role();
            role.setName(name);
            role.setDescription(description);
            role.setStatus(Integer.parseInt(status));
            dao.insertRole(role);
            response.sendRedirect("/admin/roles");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("enumRole", EnumRole.values());
        request.getRequestDispatcher("/views/admin/roles/addRole.jsp").forward(request, response);
    }
}
