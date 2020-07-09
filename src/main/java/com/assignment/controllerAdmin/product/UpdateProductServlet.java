package com.assignment.controllerAdmin.product;

import com.assignment.dao.CategoryDAO;
import com.assignment.dao.ProductDAO;
import com.assignment.model.Attribute;
import com.assignment.model.Enum.EnumProduct;
import com.assignment.model.Product;
import com.assignment.model.validate.CategoryForm;
import com.assignment.model.validate.ProductForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UpdateServlet")
public class UpdateProductServlet extends HttpServlet {
    ProductDAO productDAO = new ProductDAO();
    CategoryDAO categoryDAO = new CategoryDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("err.jsp");
        PrintWriter pw = response.getWriter();
        int id = Integer.parseInt(request.getParameter("idUpdateProduct"));
        String name = request.getParameter("nameUpdateProduct");
        String image = request.getParameter("imageUpdateProduct");
        int categoryId = Integer.parseInt(request.getParameter("categoryUpdateProduct"));
        int price = Integer.parseInt(request.getParameter("priceUpdateProduct"));
        int quantity = Integer.parseInt(request.getParameter("quantityUpdateProduct"));
        String description = request.getParameter("descriptionUpdateProduct");
        int status = Integer.parseInt(request.getParameter("statusUpdateProduct"));
        ProductForm productForm = new ProductForm(name, image, String.valueOf(price), String.valueOf(quantity), description);
        if (productForm.getErrors().size() > 0) {
            request.setAttribute("errorsP", productForm.getErrors());
            request.getRequestDispatcher("/views/admin/products/updateProduct.jsp").forward(request, response);
        }
        else {
            Product product = new Product(id, name, image, price, quantity, description, status, categoryId);
            productDAO.updateProduct(product);
            response.sendRedirect("/admin/products");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null && id.length() > 0) {
            HttpSession session=request.getSession();
            session.setAttribute("enumUpdateProduct", EnumProduct.values());
            session.setAttribute("getProductUpdate", productDAO.getProduct(Integer.parseInt(id)));
            session.setAttribute("getCategoriesUpdate", categoryDAO.getAllCategory());
            session.setAttribute("getAttributesUpdate", productDAO.getAllAttribute());
            request.getRequestDispatcher("/views/admin/products/updateProduct.jsp").forward(request, response);
        } else {
            response.sendRedirect("/admin/error");
        }

    }
}
