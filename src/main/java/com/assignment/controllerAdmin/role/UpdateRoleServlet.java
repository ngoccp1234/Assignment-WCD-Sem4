package com.assignment.controllerAdmin.role;

import com.assignment.dao.RoleDAO;
import com.assignment.model.Enum.EnumRole;
import com.assignment.model.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateRoleServlet")
public class UpdateRoleServlet extends HttpServlet {
    RoleDAO dao = new RoleDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idUpdateRole"));
        String name = request.getParameter("nameUpdateRole");
        String description = request.getParameter("descriptionUpdateRole");
        int status = Integer.parseInt(request.getParameter("statusUpdateRole"));
        Role role = new Role(id, name, description, status);
        dao.updateRole(role);
        response.sendRedirect("/admin/roles");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null && id.length() > 0)
        {
            request.setAttribute("getRole", dao.getRole(Integer.parseInt(id)));
            request.setAttribute("enumUpdateRole", EnumRole.values());
            request.getRequestDispatcher("/views/admin/roles/updateRole.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("admin/error");
        }

    }
}
