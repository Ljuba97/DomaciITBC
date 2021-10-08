package com.example.demo.dao;

import com.example.demo.db.DatabaseConnection;
import com.example.demo.model.FoodModel;
import com.example.demo.model.MealModel;
import com.example.demo.model.request.MealRequestModel;
import com.example.demo.model.response.MealResponseModel;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MealDaoSQL {
    private static final Connection conn = DatabaseConnection.getConnection();

    public void add(MealModel mm) {
        String query = "INSERT INTO meal (meal_id, meal_name, meal_desc, meal_difficulty) " +
                "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement st = conn.prepareStatement(query);

            st.setInt(1, mm.getMeal_id());
            st.setString(2, mm.getMeal_name());
            st.setString(3, mm.getMeal_desc());
            st.setString(4, mm.getMeal_difficulty());

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMealGrade(int user_id, int meal_id, int grade) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO usermeal (user_id, meal_id, grade) VALUES (?, ?, ?) " +
                    "ON CONFLICT (user_id, meal_id) DO UPDATE SET grade = ?");

            st.setInt(1, user_id);
            st.setInt(2, meal_id);
            st.setInt(3, grade);
            st.setInt(4, grade);

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM meal WHERE meal_id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);

            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(MealModel mm) {
        String query = "UPDATE meal SET meal_name = ?, meal_desc = ?, meal_difficulty = ? " +
                "WHERE meal_id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);

            st.setString(1, mm.getMeal_name());
            st.setString(2, mm.getMeal_desc());
            st.setString(3, mm.getMeal_difficulty());
            st.setInt(4, mm.getMeal_id());

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public MealModel getMeal(int id) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM meal WHERE meal_id = " + id);

            if (rs.next())
                return new MealModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<MealRequestModel> getAllMeals() {
        List<MealRequestModel> list = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM meal");

            while (rs.next())
                list.add(new MealRequestModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String> getAllMealNames() {
        List<String> list = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT meal_name FROM meal");

            while (rs.next())
                list.add(rs.getString(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String> getMealNames(String search) {
        search = search.toLowerCase();
        search = search.replaceAll(", ", " ").replaceAll(",", " ");
        HashSet<String> mealNameList = new HashSet<>();
        String[] searchArray = search.split(" ");
        try {
            for (String s : searchArray) {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT meal_name FROM meal WHERE LOWER(meal_name) LIKE '%" + s + "%' " +
                        " OR LOWER(meal_desc) LIKE '%" + s + "%'");
                while (rs.next()) {
                    mealNameList.add(rs.getString(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(mealNameList);
    }

    public List<String> getFoodMealNames(int meal_id) {
        List<String> list = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT food_name FROM food f INNER JOIN mealfood mf ON mf.food_id = f.food_id WHERE meal_id = " + meal_id);

            while (rs.next())
                list.add(rs.getString(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<FoodModel> getFoodMeal(int meal_id) {
        List<FoodModel> list = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT f.* FROM food f INNER JOIN mealfood mf ON mf.food_id = f.food_id WHERE meal_id = " + meal_id);

            while (rs.next())
                list.add(new FoodModel(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6)));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<MealRequestModel> searchMeal(String name, double kcal) {
        List<MealRequestModel> list = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT m.* FROM meal m INNER JOIN " +
                    "mealfood mf ON mf.meal_id = m.meal_id INNER JOIN food f on mf.food_id = f.food_id " +
                    "WHERE LOWER(meal_name) LIKE '%" + name + "%' GROUP BY m.meal_id HAVING SUM(food_kcal) < " + kcal);

            while (rs.next())
                list.add(new MealRequestModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<MealResponseModel> searchMealsAndFood() {
        List<MealResponseModel> list = new ArrayList<>();
        List<String> foodNames = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            Statement st1 = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT meal_name, SUM(f.food_kcal) " +
                    "FROM meal m INNER JOIN mealfood mf ON mf.meal_id = m.meal_id " +
                    "INNER JOIN food f ON mf.food_id = f.food_id GROUP BY meal_name");

            ResultSet rs1 = null;
            while (rs.next()) {
                rs1 = st1.executeQuery("SELECT f.food_name FROM meal m " +
                        "INNER JOIN mealfood mf ON mf.meal_id = m.meal_id " +
                        "INNER JOIN food f ON mf.food_id = f.food_id " +
                        "WHERE meal_name = '" + rs.getString(1) + "' GROUP BY meal_name, f.food_name");

                while (rs1.next())
                    foodNames.add(rs1.getString(1));
                list.add(new MealResponseModel(rs.getString(1), rs.getDouble(2), foodNames));
                foodNames = new ArrayList<>();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /*public List<MealRequestModel> searchMealAdvanced(String name, double kcal, List<String> foodNames) {
        List<MealRequestModel> list = new ArrayList<>();

        String str = "";
        for (String s : foodNames)
            str = str.concat("'").concat(s).concat("', ");
        str = str.substring(0, str.length() - 2);

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT m.* FROM meal m INNER JOIN " +
                    "mealfood mf ON mf.meal_id = m.meal_id INNER JOIN food f on mf.food_id = f.food_id " +
                    "WHERE LOWER(meal_name) LIKE '%" + name + "%' AND f.food_name NOT IN (" + str + ") " +
                    "GROUP BY m.meal_id, f.food_name HAVING SUM(food_kcal) < " + kcal);

            while (rs.next())
                list.add(new MealRequestModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }*/
}
