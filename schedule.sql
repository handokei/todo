use schedule;
CREATE TABLE todo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    name VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL ,
    planTodo VARCHAR(300) NOT NULL ,
    createDate DATETIME NOT NULL ,
    editDate DATETIME NOT NULL
);