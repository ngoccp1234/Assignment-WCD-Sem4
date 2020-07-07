package com.assignment.controllerAdmin.product;

import com.assignment.dao.CategoryDAO;
import com.assignment.dao.ProductDAO;
import com.assignment.model.Attribute;
import com.assignment.model.Enum.EnumProduct;
import com.assignment.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddProductServlet")
public class AddProductServlet extends HttpServlet {
    CategoryDAO categoryDAO = new CategoryDAO();
    ProductDAO productDAO = new ProductDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameProduct");
        String image = request.getParameter("imageProduct");
        String price = request.getParameter("priceProduct");
        String quantity = request.getParameter("quantityProduct");
        String description = request.getParameter("descriptionProduct");
        String status = request.getParameter("statusProduct");
        String category = request.getParameter("categoryProduct");
        String[]attributes = request.getParameterValues("attributeId");
        Product product = new Product();
        product.setName(name);
        product.setImage(image);
        product.setPrice(Integer.parseInt(price));
        product.setQuantity(Integer.parseInt(quantity));
        product.setDescription(description);
        product.setStatus(Integer.parseInt(status));
        product.setCategory_id(Integer.parseInt(category));
        if (attributes != null && attributes.length > 0)
        {
            List<Attribute> list = new ArrayList<Attribute>();
            for (String idAttr : attributes)
            {
                Attribute attribute = productDAO.getAttribute(Integer.parseInt(idAttr));
                list.add(attribute);
            }
            product.setAttributes(list);
        }
        productDAO.insertProduct(product);
        response.sendRedirect("/admin/products");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("getCategories", categoryDAO.getAllCategory());
        request.setAttribute("enumProduct", EnumProduct.values());
        request.setAttribute("attributeList", productDAO.getAllAttribute());
        request.getRequestDispatcher("/views/admin/products/addProduct.jsp").forward(request, response);
    }
}
