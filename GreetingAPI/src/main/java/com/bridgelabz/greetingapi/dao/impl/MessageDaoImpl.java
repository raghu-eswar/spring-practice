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
    public Message addMessage(Message message) {

        String insertQuery = "INSERT INTO messages VALUES (?, ?, default, default)";
        try {
            getJdbcTemplate().update(insertQuery, message.getId(), message.getMessage());
        }catch (DuplicateKeyException exception) {
            message.setId(getMessageId(message.getMessage()));
            return message;
        }
        message.setId(getLastInsertId());
        return message;
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

    @Override
    public Message updateMessage(int messageId, Message message) {
        String sql = "SELECT COUNT(*) FROM users WHERE message_id = ?";
        Integer noOfRecords = getJdbcTemplate().query(sql, new Object[]{messageId}, rs -> {
            rs.next();
            return rs.getInt(1);
        });
        if (noOfRecords > 1)
            return addMessage(message);
        try{
            String updateQuery = "UPDATE messages SET message = ? WHERE message_id = ?";
            getJdbcTemplate().update(updateQuery, message.getMessage(), messageId);
            message.setId(messageId);
            return message;
        }catch (DuplicateKeyException exception) {
            message.setId(getMessageId(message.getMessage()));
            return message;
        }
    }

    private Integer getMessageId(String message) {
        String selectQuery = "SELECT * FROM messages WHERE message = ?";
        return getJdbcTemplate().query(selectQuery, new Object[]{message}, rs -> {
            rs.next();
            return rs.getInt("message_id");
        });
    }

    private Integer  getLastInsertId() {
        return getJdbcTemplate().query("SELECT LAST_INSERT_ID()", rs -> {
            rs.next();
            return rs.getInt("LAST_INSERT_ID()");
        });
    }

}
