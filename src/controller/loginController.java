package controller;

import connection.dbConnect;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class loginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cookie[] cookies = req.getCookies();
//        boolean redirected = false;
//        for (Cookie cookie : cookies) {
//            if (cookie.getName().equals("login")) {
//                resp.sendRedirect("/hello");
//                redirected = true;
//            }
//        }
//        if (!redirected) {
//            req.getRequestDispatcher("/login.jsp").forward(req, resp);
//        }
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        if (checkLogin(name, pass)) {
            Cookie c = new Cookie("login", name);
            resp.addCookie(c);
        }
        resp.sendRedirect("/hello");
    }

    private boolean checkLogin(String name, String pass) {
        try {
            Connection con = dbConnect.initializeDatabase();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select name, password from demo");

            while (rs.next())
            {
                String username = rs.getString("name");
                String userpass = rs.getString("password");

                if (username.equals(name) && userpass.equals(pass)) {
                    return true;
                }
            }
            st.close();
            con.close();

            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
