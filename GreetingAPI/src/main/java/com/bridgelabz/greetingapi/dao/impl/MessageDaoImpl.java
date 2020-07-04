package com.bridgelabz.greetingapi.dao.impl;

import com.bridgelabz.greetingapi.dao.MessageDao;
import com.bridgelabz.greetingapi.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class MessageDaoImpl extends JdbcDaoSupport implements MessageDao {

    @Autowired
    DataSource dataSource;
    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public Integer addMessage(Message message) {
        String sql = "INSERT INTO messages VALUES (?, ?, default, default)";
        Integer user_id = getJdbcTemplate().query("SELECT LAST_INSERT_ID()", rs -> (rs.next()) ? rs.getInt("LAST_INSERT_ID()") : null);
        getJdbcTemplate().update(sql, message.getId(), message.getMessage());
        return getJdbcTemplate().query("SELECT LAST_INSERT_ID()", rs -> {
            rs.next();
            return rs.getInt("LAST_INSERT_ID()");
        });
    }
}
