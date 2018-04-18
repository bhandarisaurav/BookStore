package service;

import dbUtils.DBConnection;
import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {


    String table_name = "users";
    private Connection con = new DBConnection().getConnection();


    public User getUser(String username, String password) {

        String query = "SELECT * from " + table_name + " WHERE username = ? and password = ?";
        User user = null;

        PreparedStatement pstm;
        try {
            pstm = con.prepareStatement(query);
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}