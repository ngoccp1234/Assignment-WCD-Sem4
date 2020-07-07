package com.assignment.controllerClient;

import com.assignment.dao.CategoryDAO;
import com.assignment.dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductsServlet")
public class ProductsServlet extends HttpServlet {
    CategoryDAO categoryDAO = new CategoryDAO();
    ProductDAO productDAO = new ProductDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") == null)
        {
            request.setAttribute("getAllProductList", productDAO.getAllProduct());
        }
        else
        {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("getAllProductList",categoryDAO.getProductsByCategory(id));
        }
        request.setAttribute("attrProducts", productDAO.getAllAttribute());
        request.getRequestDispatcher("/views/client/listProduct.jsp").forward(request, response);
    }
}
