package controller;

import entity.Feedback;
import entity.User;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class feedbackController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fbcontent = req.getParameter("fb");
        int userId = Integer.valueOf(req.getParameter("userId"));
        Feedback fb = new Feedback();
        fb.setFeedback(fbcontent);
        fb.setUserId(userId);

        if (!fb.isValid()) {
            req.setAttribute("fb", fb);
            req.setAttribute("errors", fb.getError());
            req.getRequestDispatcher("/feedback.jsp").forward(req, resp);
            return;
        }

        UserModel userM = new UserModel();
        userM.InsertFb(fb);
        resp.sendRedirect("/home");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/feedback.jsp").forward(req, resp);
    }
}
