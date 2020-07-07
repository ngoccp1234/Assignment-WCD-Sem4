package com.assignment.controllerAdmin.product;

import com.assignment.dao.CategoryDAO;
import com.assignment.dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListProductServlet")
public class ListProductServlet extends HttpServlet {
    ProductDAO productDAO = new ProductDAO();
    CategoryDAO categoryDAO = new CategoryDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       request.setAttribute("getEnumToListP", EnumProduct.values());
        request.setAttribute("getAllProduct", productDAO.getAllProduct());

        request.getRequestDispatcher("/views/admin/products/listProduct.jsp").forward(request, response);
    }
}
