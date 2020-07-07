package com.assignment.controllerAdmin.role;

import com.assignment.dao.RoleDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteRoleServlet")
public class DeleteRoleServlet extends HttpServlet {
    RoleDAO dao = new RoleDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idDelete = request.getParameter("idRoleDelete");
        if (idDelete != null && idDelete.length() > 0)
        {
            dao.deleteRole(Integer.parseInt(idDelete));
            response.sendRedirect("/admin/roles");
        }else
        {
            response.sendRedirect("/admin/error");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null && id.length() > 0)
        {
            request.setAttribute("getRoleDelete", dao.getRole(Integer.parseInt(id)));
            request.getRequestDispatcher("/views/admin/roles/deleteRole.jsp").forward(request, response);
        }else
        {
            response.sendRedirect("/admin/error");
        }

    }
}
