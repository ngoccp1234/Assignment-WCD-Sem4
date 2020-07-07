package com.assignment.controllerClient;

import com.assignment.dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet")
public class ProductServlet extends HttpServlet {
    ProductDAO productDAO = new ProductDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null && id.length() > 0)
        {
            request.setAttribute("getProductDetail", productDAO.getProduct(Integer.parseInt(id)));
            request.setAttribute("AttrProductDetail", productDAO.getAllAttribute());
            request.setAttribute("getAllProductDetail", productDAO.getAllProduct());
            request.getRequestDispatcher("/views/client/detailProduct.jsp").forward(request, response);
        }else
        {
            response.sendRedirect("/error");
        }

    }
}
