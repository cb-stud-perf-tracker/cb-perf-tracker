package com.trackers.cbtracker;

import java.sql.*;

public class StudentDao {

    // Hard-coded credentials (not secure, not flexible)
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cb_perf_db";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "password";

    public StudentDao() {
        // No parameters needed; the strings are above
    }

    public void saveOrUpdatePerformance(String email, String date, String[] columns) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS)) {
            // Example SQL
            String sql = "INSERT INTO performance_record (...) VALUES (...) "
                       + "ON DUPLICATE KEY UPDATE ...";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                // set params...
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}