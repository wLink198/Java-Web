package model;

import connection.dbConnect;
import entity.Feedback;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserModel {
    public boolean Insert(User user) {
        try {

            // Initialize the database
            Connection con = dbConnect.initializeDatabase();

            // Create a SQL query to insert data into demo table
            // demo table consists of two columns, so two '?' is used
            PreparedStatement st = con
                    .prepareStatement("insert into demo(name, password) values(?, ?)");

            st.setString(1, user.getName());
            st.setString(2, user.getPassword());

            // Execute the insert command using executeUpdate()
            // to make changes in database
            st.executeUpdate();

            // Close all the connections
            st.close();
            con.close();

            // Get a writer pointer
            // to display the succesful result
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean InsertFb(Feedback fb) {
        try {

            // Initialize the database
            Connection con = dbConnect.initializeDatabase();

            // Create a SQL query to insert data into demo table
            // demo table consists of two columns, so two '?' is used
            PreparedStatement st = con
                    .prepareStatement("insert into feedback(feedback, userId) values(?, ?)");

            st.setString(1, fb.getFeedback());
            st.setInt(2, fb.getUserId());

            // Execute the insert command using executeUpdate()
            // to make changes in database
            st.executeUpdate();

            // Close all the connections
            st.close();
            con.close();

            // Get a writer pointer
            // to display the succesful result
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    ArrayList<Feedback> fb = new ArrayList<Feedback>();
    public ArrayList<Feedback> getFeedback() {
        Connection con = null;
        try {
            con = dbConnect.initializeDatabase();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select feedback.feedback, demo.name from feedback inner join demo" +
                    " on feedback.userId = demo.id;");

            while (rs.next())
            {
                String feedback = rs.getString("feedback");
                String username = rs.getString("name");

                Feedback feed = new Feedback();
                feed.setFeedback(feedback);
                feed.getUser().setName(username);
                fb.add(feed);
            }
            st.close();
            con.close();

            return fb;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
