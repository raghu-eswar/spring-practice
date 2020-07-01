package com.bridgelabz.dao;

import com.bridgelabz.model.User;
import com.bridgelabz.services.UserExtractor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class UserDao {
    private static final JdbcTemplate jdbcTemplate = new JdbcTemplate();
    private static final String ADD_USER_STATEMENT = "insert into userInfo values(?, ?, ?, ?, ?)";
    private static final String SELECT_USER_STATEMENT = "select * from userInfo where emailId=? and password=?";
    private static final String READ_USER_STATEMENT = "select * from userInfo where id=?";
    private static final String UPDATE_USER_STATEMENT = "update userInfo set firstName =?, lastName = ?, emailId = ? where id = ?";

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

    public static User createUser(String email, String password){
        return jdbcTemplate.query(SELECT_USER_STATEMENT, new Object[]{email, password}, new UserExtractor());
    }

    public static boolean updateUser(User newUser, User user) {
        int updatedRows = jdbcTemplate.update(UPDATE_USER_STATEMENT, newUser.getFirstName(),
                                                newUser.getLastName(), newUser.getEmail(), user.getId());
        return updatedRows == 1;
    }

    public static User readUser(int userId) {
        return jdbcTemplate.query(READ_USER_STATEMENT, new Object[]{userId}, new UserExtractor());
    }
}
