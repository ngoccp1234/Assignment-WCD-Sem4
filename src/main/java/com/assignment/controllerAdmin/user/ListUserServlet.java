package com.assignment.controllerAdmin.user;

import com.assignment.dao.RoleDAO;
import com.assignment.dao.UserDAO;
import com.assignment.model.Role;
import com.assignment.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListUserServlet")
public class ListUserServlet extends HttpServlet {
    UserDAO userDAO = new UserDAO();
    RoleDAO roleDAO = new RoleDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User>userList = userDAO.getAllUser();
        request.setAttribute("listUser", userList);
        request.getRequestDispatcher("/views/admin/users/listUser.jsp").forward(request, response);
    }
}
