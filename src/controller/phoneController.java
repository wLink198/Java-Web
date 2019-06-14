package controller;

import entity.Feedback;
import entity.Phone;
import model.PhoneModel;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/phone/create")
public class phoneController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addphone.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        int price = Integer.valueOf(req.getParameter("price"));
        String description = req.getParameter("description");
        Phone phone = new Phone(name, brand, price, description);

//        if (!phone.isValid()) {
//            req.setAttribute("phone", phone);
//            req.setAttribute("errors", phone.getError());
//            req.getRequestDispatcher("/addphone.jsp").forward(req, resp);
//            return;
//        }

        PhoneModel phoneM = new PhoneModel();
        phoneM.Insert(phone);
        resp.sendRedirect("/home");
    }
}
