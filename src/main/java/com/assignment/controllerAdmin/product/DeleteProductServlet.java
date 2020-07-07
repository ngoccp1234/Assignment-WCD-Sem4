package com.assignment.controllerAdmin.product;

import com.assignment.dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
    ProductDAO productDAO = new ProductDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idDelete = request.getParameter("idPDelete");
        if (idDelete != null && idDelete.length() > 0)
        {
            productDAO.deleteProduct(Integer.parseInt(idDelete));
            response.sendRedirect("/admin/products");
        }else
        {
            response.sendRedirect("/admin/error");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null && id.length() > 0)
        {
            request.setAttribute("getProductDelete", productDAO.getProduct(Integer.parseInt(id)));
            request.getRequestDispatcher("/views/admin/products/deleteProduct.jsp").forward(request, response);
        }else
        {
            response.sendRedirect("/admin.error");
        }

    }
}
