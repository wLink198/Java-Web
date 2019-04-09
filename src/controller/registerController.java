package controller;

import entity.User;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class registerController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");
        String password = req.getParameter("password");
        User user = new User(userName, password);
        boolean registered;

        if (!user.isValid()) {
            req.setAttribute("user", user);
            req.setAttribute("errors", user.getError());
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        UserModel userM = new UserModel();
        registered = userM.Insert(user);
        resp.sendRedirect("/login" + "?registered=" + registered);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }
}
