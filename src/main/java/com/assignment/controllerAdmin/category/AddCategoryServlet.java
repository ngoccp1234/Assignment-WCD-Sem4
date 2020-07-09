package com.assignment.controllerAdmin.category;

import com.assignment.dao.CategoryDAO;
import com.assignment.model.Category;
import com.assignment.model.Enum.EnumCategory;
import com.assignment.model.validate.CategoryForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {
    CategoryDAO dao = new CategoryDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("err.jsp");
//        PrintWriter pw = response.getWriter();
        String name = request.getParameter("nameCategory");
        int status = Integer.parseInt(request.getParameter("statusCategory"));
        String image = request.getParameter("imageCategory");
        String description = request.getParameter("descriptionCategory");
        CategoryForm categoryForm = new CategoryForm(name, image, description);
        if (categoryForm.getErrors().size() > 0) {
            request.setAttribute("errors", categoryForm.getErrors());
            request.getRequestDispatcher("/views/admin/categories/addCategory.jsp").forward(request, response);
        } else {
            Category category = new Category();
            category.setName(name);
            category.setImage(image);
            category.setDescription(description);
            category.setStatus(status);
            dao.insertCategory(category);
            response.sendRedirect("/admin/categories");
        }
//        if ((name == null) || (name.equals(""))) {
//            pw.write("PROVIDE CATEGORY NAME...");
//        } else if ((image == null) || (image.equals(""))) {
//            pw.write("PROVIDE CATEGORY IMAGE...");
//        } else if ((description == null) || (description.equals(""))) {
//            pw.write("PROVIDE CATEGORY DESCRIPTION...");
//        } else if ((name.length() <= 5) || (name.length() >= 50)) {
//            pw.write("NAME >= 5 AND <=50");
//        } else if ((description.length() <= 5) || (description.length() >= 500)) {
//            pw.write("DESCRIPTION >= 5 AND <=500");
//        } else {
//            Category category = new Category();
//            category.setName(name);
//            category.setImage(image);
//            category.setDescription(description);
//            category.setStatus(status);
//            dao.insertCategory(category);
//            response.sendRedirect("/admin/categories");
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("enumCategory", EnumCategory.values());
        HttpSession session = request.getSession();
        session.setAttribute("enumCategory", EnumCategory.values());
        request.getRequestDispatcher("/views/admin/categories/addCategory.jsp").forward(request, response);
    }
}
