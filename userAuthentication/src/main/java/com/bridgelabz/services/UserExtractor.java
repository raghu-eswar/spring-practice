package com.bridgelabz.services;

import com.bridgelabz.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserExtractor implements ResultSetExtractor<User> {

    @Override
    public User extractData(ResultSet rs) throws SQLException, DataAccessException {
        if (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setEmail(rs.getString("emailId"));
            user.setPassword(rs.getString("password"));
            return user;
        }
        return null;
    }
}
