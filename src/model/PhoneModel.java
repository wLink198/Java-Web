package model;

import connection.dbConnect;
import entity.Feedback;
import entity.Phone;
import entity.User;

import java.sql.*;
import java.util.ArrayList;

public class PhoneModel {
    public boolean Insert(Phone phone) {
        try {
            Connection con = dbConnect.initializeDatabase();

            PreparedStatement st = con
                    .prepareStatement("insert into phone (name, brand, price, description) values(?, ?, ?, ?)");

            st.setString(1, phone.getName());
            st.setString(2, phone.getBrand());
            st.setInt(3, phone.getPrice());
            st.setString(4, phone.getDescription());

            st.executeUpdate();

            st.close();
            con.close();

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    ArrayList<Phone> fb = new ArrayList<Phone>();
    public ArrayList<Phone> getPhone() {
        Connection con = null;
        try {
            con = dbConnect.initializeDatabase();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from phone");

            while (rs.next())
            {
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                int price = rs.getInt("price");
                String description = rs.getString("description");

                Phone phone = new Phone(name, brand, price, description);
                fb.add(phone);
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
