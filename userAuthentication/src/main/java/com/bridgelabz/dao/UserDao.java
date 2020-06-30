package com.bridgelabz.dao;

import com.bridgelabz.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class UserDao {
    private static final JdbcTemplate jdbcTemplate = new JdbcTemplate();
    private static final String ADD_USER_STATEMENT = "insert into userInfo values(?, ?, ?, ?, ?)";

    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies.xml");
        DriverManagerDataSource dataSource = (DriverManagerDataSource) context.getBean("dataSource");
        jdbcTemplate.setDataSource(dataSource);
    }

    public static boolean addNewUser(User user) {
        int updatedRows = jdbcTemplate.update(ADD_USER_STATEMENT, user.getId(), user.getFirstName(),
                user.getLastName(), user.getEmail(), user.getPassword());
        return updatedRows == 1;
    }

}
