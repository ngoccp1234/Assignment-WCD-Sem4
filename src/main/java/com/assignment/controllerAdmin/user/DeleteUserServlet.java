package com.assignment.controllerAdmin.user;

import com.assignment.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    UserDAO userDAO = new UserDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idUserDelete = request.getParameter("idUserDelete");
//        userDAO.deleteUser(idUserDelete);
        if (idUserDelete != null && idUserDelete.length() > 0)
        {
            userDAO.deleteUser(Integer.parseInt(idUserDelete));
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
            request.setAttribute("getUserDelete", userDAO.getUser(Integer.parseInt(id)));
            request.getRequestDispatcher("/views/admin/users/deleteUser.jsp").forward(request, response);
        }else
        {
            response.sendRedirect("/admin/error");
        }

    }
}
