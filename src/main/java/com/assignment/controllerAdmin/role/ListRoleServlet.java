package com.assignment.controllerAdmin.role;

import com.assignment.dao.RoleDAO;
import com.assignment.model.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListRoleServlet")
public class ListRoleServlet extends HttpServlet {
    RoleDAO dao  = new RoleDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Role>list = dao.getAllRole();
        request.setAttribute("getListRole", list);
        request.getRequestDispatcher("/views/admin/roles/listRole.jsp").forward(request, response);
    }
}
