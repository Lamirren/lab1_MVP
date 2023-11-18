package com.example.demo.servlets;

import java.io.*;
import java.util.Date;

import com.example.demo.almostdatabase.User;
import com.example.demo.almostdatabase.UserDatabase;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//com for pull
@WebServlet(name = "loginServlet" /*, value = "/hello"*/)
public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        User admin = new User("admin", "admin");
        User user1 = new User("user1", "123");
        User user2 = new User("user2", "123");
        User secret = new User("secret", "secret");

        UserDatabase.addUser(admin);
        UserDatabase.addUser(user1);
        UserDatabase.addUser(user2);
        UserDatabase.addUser(secret);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/auth.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("username");
        String password = req.getParameter("password");

        boolean isLogPassValid = UserDatabase.checkPassword(login, password);

        if (isLogPassValid) {
            routing(req, resp, login);
        } else {
            req.setAttribute("isLogPassValid", false);
            req.getRequestDispatcher("views/auth.jsp").forward(req, resp);
        }
    }

    private static void routing(HttpServletRequest req, HttpServletResponse resp, String login) throws ServletException, IOException {
        if ("secret".equals(login)) {
            resp.sendRedirect("https://www.youtube.com/watch?v=E8gmARGvPlI");
        } else {
            resp.sendRedirect(req.getContextPath() + "/time");
        }
    }
}