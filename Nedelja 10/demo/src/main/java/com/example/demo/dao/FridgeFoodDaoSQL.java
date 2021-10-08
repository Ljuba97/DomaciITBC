package com.example.demo.dao;

import com.example.demo.db.DatabaseConnection;
import com.example.demo.model.FridgeFoodModel;
import com.example.demo.model.FridgeModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FridgeFoodDaoSQL {
    private static final Connection conn = DatabaseConnection.getConnection();

    public List<FridgeFoodModel> getAllFridges() {
        List<FridgeFoodModel> res = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM fridgefood");

            while (rs.next())
                res.add(new FridgeFoodModel(rs.getInt(1), rs.getInt(2), rs.getDouble(3)));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public double getMassById(int id) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT mass FROM fridgefood WHERE food_id =" + id);

            if (rs.next())
                return rs.getDouble(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void delete(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM fridgefood WHERE food_id = ?");

            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, double mass) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE fridgefood SET mass = fridgefood.mass - ? WHERE food_id = ?");

            st.setDouble(1, mass);
            st.setInt(2, id);

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
