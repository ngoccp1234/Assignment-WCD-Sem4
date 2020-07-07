package com.assignment.controllerAuth;

import com.assignment.dao.UserDAO;
import com.assignment.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginClientServlet")
public class LoginClientServlet extends HttpServlet {
    UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("usernameUser");
//        String password = request.getParameter("passwordUser");
//        User user = userDAO.doLogin(username, password);
//        if (user != null) {
//            HttpSession session = request.getSession();
//            session.setAttribute("user", user);
//            response.sendRedirect("home");
//        } else {
//            response.sendRedirect("login");
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
//        if (user != null) {
//            response.sendRedirect("home");
//        } else {
//            request.getRequestDispatcher("views/client/login.jsp").forward(request, response);
//        }
        request.getRequestDispatcher("/views/client/login.jsp").forward(request, response);

    }
}
