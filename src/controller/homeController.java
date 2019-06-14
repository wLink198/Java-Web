package controller;

import entity.Feedback;
import entity.Phone;
import model.PhoneModel;
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
        PhoneModel phone = new PhoneModel();
        ArrayList<Phone> phoneList = phone.getPhone();

        req.setAttribute("phoneList", phoneList);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
