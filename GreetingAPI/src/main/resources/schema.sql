DROP TABLE IF EXISTS messages;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    userId int primary key auto_increment,
    first_name VARCHAR(15) NOT NULL,
    last_name VARCHAR(15) NULL,
    created_date_time datetime default current_timestamp,
    updated_date_time datetime default current_timestamp on update now()
);

CREATE TABLE messages (
    messages_id int primary key auto_increment,
    messages VARCHAR(100) NOT NULL,
    user_id numeric references users(user_id),
    created_date_time datetime default current_timestamp,
    updated_date_time datetime default current_timestamp on update now()
);
