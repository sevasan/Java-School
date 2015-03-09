package ru.tsystems.eCare.controller;

import ru.tsystems.eCare.entity.User;
import ru.tsystems.eCare.service.implementation.OperatorServiceImpl;
import ru.tsystems.eCare.service.interfaces.OperatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sevasan on 3/5/2015.
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        OperatorService operatorService = new OperatorServiceImpl();
        User user = operatorService.findUserByEmail(email);

        if (user != null) {
            if (user.getUserPassword().equals(password)) {
                request.getSession().removeAttribute("errorMessage");
                request.getSession().setAttribute("currentUser", user);
                response.sendRedirect(request.getContextPath() + "/secure/operator/Cabinet.jsp");
            }
        } else {
            request.getSession().invalidate();
            request.getSession().setAttribute("errorMessage", "Wrong login/password!");
            response.sendRedirect(request.getContextPath() + "/LoginPage.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
