package com.assignment.controllerClient;

import com.assignment.dao.CategoryDAO;
import com.assignment.dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "HomeServlet")
public class HomeServlet extends HttpServlet {
    CategoryDAO categoryDAO = new CategoryDAO();
    ProductDAO productDAO = new ProductDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") == null)
        {
            request.setAttribute("productsClient", productDAO.getAllProduct());
        }
        else
        {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("productsClient",categoryDAO.getProductsByCategory(id));
        }
        HttpSession session = request.getSession();
        session.setAttribute("categoriesClient", categoryDAO.getAllCategory());
//        request.setAttribute("categoriesClient", categoryDAO.getAllCategory());
        request.getRequestDispatcher("/views/client/home.jsp").forward(request, response);
//        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
