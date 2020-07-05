DROP TABLE IF EXISTS messages;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS greetings;

CREATE TABLE users (
    user_id int primary key auto_increment,
    first_name VARCHAR(15) NOT NULL,
    last_name VARCHAR(15) NULL,
    message_id numeric not null references messages(messages_id),
    created_date_time datetime default current_timestamp,
    updated_date_time datetime default current_timestamp on update now()
);

CREATE TABLE messages (
    message_id int primary key auto_increment,
    message VARCHAR(100) unique NOT NULL,
    created_date_time datetime default current_timestamp,
    updated_date_time datetime default current_timestamp on update now()
);