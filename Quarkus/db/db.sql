create database "quarkus-social";

create table USERS
(
    id   bigserial    not null primary key,
    name varchar(100) not null,
    age  integer      not null
);

create table POSTS
(
    id   bigserial    not null primary key,
    post_text varchar(150) not null,
    dateTime  timestamp not null ,
    user_id bigint not null references users(id)
)

create table FOLLOWERS(
    id bigserial not null primary key,
    user_id bigint not null references USERS(id),
    follower_id bigint not null references USERS(id)
);

