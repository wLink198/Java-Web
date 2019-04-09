package controller;

import entity.Feedback;
import model.UserModel;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class homeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel us = new UserModel();
        ArrayList<Feedback> feedbackList = us.getFeedback();

        req.setAttribute("feedback", feedbackList);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
