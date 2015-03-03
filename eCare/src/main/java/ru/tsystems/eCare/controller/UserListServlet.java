package ru.tsystems.eCare.controller;

import ru.tsystems.eCare.service.implementation.UserServiceImpl;
import ru.tsystems.eCare.service.interfaces.UserService;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by sevasan on 3/1/2015.
 */

public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = MyEntityManagerFactory.createEntityManager();
        UserService userService = new UserServiceImpl();
        List<String> userList = userService.getAllUsersShort();
        request.getSession().setAttribute("userList", userList);
        request.getRequestDispatcher("/UserList.jsp").forward(request, response);
        em.close();
    }
}
