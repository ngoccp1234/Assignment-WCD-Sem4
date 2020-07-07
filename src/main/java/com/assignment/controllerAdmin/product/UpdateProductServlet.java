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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UpdateServlet")
public class UpdateProductServlet extends HttpServlet {
    ProductDAO productDAO = new ProductDAO();
    CategoryDAO categoryDAO = new CategoryDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idUpdateProduct"));
        String name = request.getParameter("nameUpdateProduct");
        String image = request.getParameter("imageUpdateProduct");
        int categoryId = Integer.parseInt(request.getParameter("categoryUpdateProduct"));
        int price = Integer.parseInt(request.getParameter("priceUpdateProduct"));
        int quantity = Integer.parseInt(request.getParameter("quantityUpdateProduct"));
        String description = request.getParameter("descriptionUpdateProduct");
        int status = Integer.parseInt(request.getParameter("statusUpdateProduct"));
        String[]attributes = request.getParameterValues("attributeUpdate");
        if (attributes != null && attributes.length > 0)
        {
            List<Attribute> list = new ArrayList<Attribute>();
            for (String idAttr : attributes)
            {
                Attribute attribute = productDAO.getAttribute(Integer.parseInt(idAttr));
                list.add(attribute);
            }
            Product product = new Product(id, name, image, price, quantity, description, status, categoryId, list);
            productDAO.updateProduct(product);

        }
//        Product product = new Product(id, name, image, price, description, status, categoryId, );
//        productDAO.updateProduct(product);
        response.sendRedirect("/admin/products");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null && id.length() > 0)
        {
            request.setAttribute("enumUpdateProduct", EnumProduct.values());
            request.setAttribute("getProductUpdate", productDAO.getProduct(Integer.parseInt(id)));
            request.setAttribute("getCategoriesUpdate", categoryDAO.getAllCategory());
            request.setAttribute("getAttributesUpdate", productDAO.getAllAttribute());
            request.getRequestDispatcher("/views/admin/products/updateProduct.jsp").forward(request, response);
        }else
        {
            response.sendRedirect("/admin/error");
        }

    }
}
