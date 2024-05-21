package com.example.oop_5_sem_2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaptopsDB {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/laptops_oop";
    private static final String USER = "root";
    private static final String PASSWORD = "кщще";

    public List<Laptop> getLaptops() throws SQLException {
        List<Laptop> laptops = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM laptops";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Laptop laptop = new Laptop(
                        rs.getInt("id"),
                        rs.getString("fabrick"),
                        rs.getString("model"),
                        rs.getString("cpu"),
                        rs.getInt("ram"),
                        rs.getInt("hdd")
                );
                laptops.add(laptop);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }

        return laptops;
    }

    public void addLaptop(Laptop laptop) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            String sql = "INSERT INTO laptops (fabrick, model, cpu, ram, hdd) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, laptop.getFabrick());
            preparedStatement.setString(2, laptop.getModel());
            preparedStatement.setString(3, laptop.getCpu());
            preparedStatement.setInt(4, laptop.getRam());
            preparedStatement.setInt(5, laptop.getHdd());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (conn != null) conn.close();
        }
    }

    public void delLaptop(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            String sql = "DELETE FROM laptops WHERE id = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (conn != null) conn.close();
        }
    }

    public void updateLaptop(Laptop laptop) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            String sql = "UPDATE laptops SET fabrick = ?, model = ?, cpu = ?, ram = ?, hdd = ? WHERE id = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, laptop.getFabrick());
            preparedStatement.setString(2, laptop.getModel());
            preparedStatement.setString(3, laptop.getCpu());
            preparedStatement.setInt(4, laptop.getRam());
            preparedStatement.setInt(5, laptop.getHdd());
            preparedStatement.setInt(6, laptop.getId());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (conn != null) conn.close();
        }
    }
}