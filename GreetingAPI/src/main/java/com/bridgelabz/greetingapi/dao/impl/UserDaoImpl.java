package com.bridgelabz.greetingapi.dao.impl;

import com.bridgelabz.greetingapi.dao.UserDao;
import com.bridgelabz.greetingapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }


    @Override
    public Integer addUser(User user) {
        String sql = "INSERT INTO users VALUES (?, ?, ?, default, default)";
        getJdbcTemplate().update(sql, user.getId(), user.getFirstName(), user.getLastName());
        return getJdbcTemplate().query("SELECT LAST_INSERT_ID()", rs -> {
            rs.next();
            return rs.getInt("LAST_INSERT_ID()");
        });
    }
}
