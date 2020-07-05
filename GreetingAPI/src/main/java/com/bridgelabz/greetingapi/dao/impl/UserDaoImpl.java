package com.bridgelabz.greetingapi.dao.impl;

import com.bridgelabz.greetingapi.dao.MessageDao;
import com.bridgelabz.greetingapi.dao.UserDao;
import com.bridgelabz.greetingapi.exceptions.UserNotFoundException;
import com.bridgelabz.greetingapi.model.User;
import com.bridgelabz.greetingapi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

    @Autowired
    DataSource dataSource;

    @Autowired
    MessageService messageService;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }


    @Override
    public Integer addUser(User user, int messageId) {
        String sql = "INSERT INTO users VALUES (?, ?, ?, ?, default, default)";
        getJdbcTemplate().update(sql, user.getId(), user.getFirstName(), user.getLastName(), messageId);
        return getLastInsertId();
    }

    @Override
    public User getUser(int userId) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        return getJdbcTemplate().query(sql, new Object[]{userId}, rs -> {
            if (!rs.next())
                throw new UserNotFoundException(userId);
            User user = new User();
            user.setId(rs.getInt("user_id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setMessageId(rs.getInt("message_id"));
            return user;
        });

    }

    private Integer  getLastInsertId() {
        return getJdbcTemplate().query("SELECT LAST_INSERT_ID()", rs -> {
            rs.next();
            return rs.getInt("LAST_INSERT_ID()");
        });
    }

}
