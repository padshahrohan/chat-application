--liquibase formatted sql

--changeset rohan:create-table-users
CREATE TABLE users
(
    id       varchar(255) NOT NULL,
    name     varchar(255),
    password varchar(255),
    CONSTRAINT pk_users PRIMARY KEY (id)
)
GO

--changeset rukhsar:create-table-groups
CREATE TABLE groups
(
    id       varchar(255) NOT NULL,
    name     varchar(255),
    CONSTRAINT pk_groups PRIMARY KEY (id)
)
GO

--changeset rukhsar:create-table-user-groups
CREATE TABLE user_groups
(
    id int IDENTITY(1,1) NOT NULL,
    userId       varchar(255) NOT NULL,
    groupId     varchar(255) NOT NULL,
    CONSTRAINT user_groups_key PRIMARY KEY (id),
    CONSTRAINT user_group_1 FOREIGN KEY (userId) REFERENCES users (id),
    CONSTRAINT user_group_2 FOREIGN KEY (groupId) REFERENCES groups (id)
)
GO

--changeset rohan:add-loggedin-to-users-table
ALTER TABLE users ADD loggedIn bit default 0 not null;
GO