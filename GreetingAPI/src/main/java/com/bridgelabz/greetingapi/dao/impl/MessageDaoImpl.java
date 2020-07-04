package com.bridgelabz.greetingapi.dao.impl;

import com.bridgelabz.greetingapi.dao.MessageDao;
import com.bridgelabz.greetingapi.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    @Override
    public Message getMessage(int messageId) {
        String sql = "SELECT * FROM messages WHERE messages_id = ?";
        return getJdbcTemplate().query(sql, new Object[]{messageId}, new ResultSetExtractor<Message>() {
            @Override
            public Message extractData(ResultSet rs) throws SQLException, DataAccessException {
                Message message = new Message();
                rs.next();
                message.setId(rs.getInt("messages_id"));
                message.setMessage(rs.getString("messages"));
                return message;
            }
        });
    }
}
