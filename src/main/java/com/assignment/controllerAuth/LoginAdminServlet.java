package com.assignment.controllerAuth;

import com.assignment.dao.UserDAO;
import com.assignment.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginAdminServlet")
public class LoginAdminServlet extends HttpServlet {
    UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        User user = userDAO.doLogin(email);
        String pass_new = user.getPassword();
        if ((pass.equals(pass_new))) {
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect("/admin");
        } else {
            response.sendRedirect("/admin-login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/admin/login.jsp").forward(request, response);
    }
}
