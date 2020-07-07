package com.assignment.controllerAdmin.category;

import com.assignment.dao.CategoryDAO;
import com.assignment.model.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListCategoryServlet")
public class ListCategoryServlet extends HttpServlet {
    CategoryDAO dao = new CategoryDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = dao.getAllCategory();
        request.setAttribute("getListCategory", categories);
//        request.setAttribute("getEnumCate", EnumCategory.values());
        request.getRequestDispatcher("/views/admin/categories/listCategory.jsp").forward(request, response);
    }
}
