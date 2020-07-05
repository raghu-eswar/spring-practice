package com.bridgelabz.greetingapi.dao.impl;

import com.bridgelabz.greetingapi.dao.MessageDao;
import com.bridgelabz.greetingapi.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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

        String insertQuery = "INSERT INTO messages VALUES (?, ?, default, default)";
        try {
            getJdbcTemplate().update(insertQuery, message.getId(), message.getMessage());
        }catch (DuplicateKeyException exception) {
            String selectQuery = "SELECT * FROM messages WHERE message = ?";
            return getJdbcTemplate().query(selectQuery, new Object[]{message.getMessage()}, rs -> {
                rs.next();
                return rs.getInt("message_id");
            });
        }
        return getLastInsertId();
    }

    @Override
    public Message getMessage(int messageId) {
        String sql = "SELECT * FROM messages WHERE message_id = ?";
        return getJdbcTemplate().query(sql, new Object[]{messageId}, rs -> {
            Message message = new Message();
            rs.next();
            message.setId(rs.getInt("message_id"));
            message.setMessage(rs.getString("message"));
            return message;
        });
    }

    private Integer  getLastInsertId() {
        return getJdbcTemplate().query("SELECT LAST_INSERT_ID()", rs -> {
            rs.next();
            return rs.getInt("LAST_INSERT_ID()");
        });
    }

}
