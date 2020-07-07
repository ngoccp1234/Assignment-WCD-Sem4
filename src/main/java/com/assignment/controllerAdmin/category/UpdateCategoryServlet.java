package com.assignment.controllerAdmin.category;

import com.assignment.dao.CategoryDAO;
import com.assignment.model.Category;
import com.assignment.model.Enum.EnumCategory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateCategoryServlet")
public class UpdateCategoryServlet extends HttpServlet {
    CategoryDAO dao = new CategoryDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idUpdateCt"));
        String name = request.getParameter("nameUpdateCt");
        String image = request.getParameter("imageUpdateCt");
        String description = request.getParameter("descriptionUpdateCt");
        int status = Integer.parseInt(request.getParameter("statusUpdateCt"));
        Category category = new Category(id, name, image,description, status);
        dao.updateCategory(category);
        response.sendRedirect("/admin/categories");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null && id.length() > 0)
        {
            request.setAttribute("getCategory", dao.getCategory(Integer.parseInt(id)));
            request.setAttribute("enumUpdateCt", EnumCategory.values());
            request.getRequestDispatcher("/views/admin/categories/updateCategory.jsp").forward(request, response);
        }else
        {
            response.sendRedirect("/admin/error");
        }

    }
}
