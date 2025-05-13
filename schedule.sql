use schedule;
CREATE TABLE schedule (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'ToDo 식별자',
    name VARCHAR(100) NOT NULL COMMENT '이름',
    password VARCHAR(100) NOT NULL COMMENT '비밀번호',
    planTodo VARCHAR(300) NOT NULL COMMENT '일정',
    createDate DATETIME NOT NULL COMMENT '생성일자',
    editDate DATETIME NOT NULL COMMENT '수정일자'
);