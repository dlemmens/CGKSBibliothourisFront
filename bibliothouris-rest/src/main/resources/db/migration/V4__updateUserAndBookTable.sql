ALTER TABLE USERS
    ADD PASSWORD VARCHAR(20) NOT NULL;


ALTER TABLE BOOKS
    MODIFY ISBN VARCHAR(20) NOT NULL,
    MODIFY TITLE VARCHAR(200) NOT NULL,
    MODIFY LAST_NAME VARCHAR(250) NOT NULL;