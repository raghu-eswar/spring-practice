package com.bridgelabz.greetingapi.dao.impl;

import com.bridgelabz.greetingapi.dao.GreetingDao;
import com.bridgelabz.greetingapi.model.Greeting;
import com.bridgelabz.greetingapi.service.MessageService;
import com.bridgelabz.greetingapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class GreetingDaoImpl extends JdbcDaoSupport implements GreetingDao {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserService userService;

    @Autowired
    MessageService messageService;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }


    @Override
    public Integer addGreeting(Greeting greeting) {
        String sql = "INSERT INTO greetings VALUES (?, ?,?, default, default)";
        getJdbcTemplate().update(sql, greeting.getId(), userService.addUser(greeting.getUser()),
                                    messageService.addMessage(greeting.getMessage()));
        return getJdbcTemplate().query("select max(greeting_id) as greetingId from greetings", rs -> {
            rs.next();
            return rs.getInt("greetingId");
        });
    }

    @Override
    public Greeting getGreeting(int greetingId) {
        String sql = "SELECT * FROM greetings WHERE greeting_id = ?";
        Greeting greeting = getJdbcTemplate().query(sql, new Object[]{greetingId}, rs -> {
            Greeting greeting1 = new Greeting();
            if (rs.next()) {
                greeting1.setId(greetingId);
                greeting1.setUser(userService.getUser(rs.getInt("user_id")));
                greeting1.setMessage(messageService.getMessage(rs.getInt("messages_id")));
                return greeting1;
            }
            return null;
        });
        return greeting;
    }
}
