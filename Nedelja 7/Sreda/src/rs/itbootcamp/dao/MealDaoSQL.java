package rs.itbootcamp.dao;

import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.MealModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MealDaoSQL implements MealDao{

    @Override
    public void insert(MealModel mm) {
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

    @Override
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

    @Override
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

    @Override
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

    @Override
    public List<MealModel> getAllMeals() {
        List<MealModel> list = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM meal");

            while (rs.next())
                list.add(new MealModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
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

    @Override
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
}
