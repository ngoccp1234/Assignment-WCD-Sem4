package com.assignment.controllerAdmin.category;

import com.assignment.dao.CategoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCategoryServlet")
public class DeleteCategoryServlet extends HttpServlet {
    CategoryDAO dao = new CategoryDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idDelete = request.getParameter("idCTDelete");
        if (idDelete != null && idDelete.length() > 0)
        {
            dao.deleteCategory(Integer.parseInt(idDelete));
            response.sendRedirect("/admin/categories");
        }else
        {
//            request.getRequestDispatcher("/views/admin/error.jsp").forward(request, response);
            response.sendRedirect("/admin/error");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null && id.length() > 0)
        {
            request.setAttribute("getCTDelete", dao.getCategory(Integer.parseInt(id)));
            request.getRequestDispatcher("/views/admin/categories/deleteCategory.jsp").forward(request, response);
        }else
        {
            response.sendRedirect("/admin/error");
        }


    }
}
