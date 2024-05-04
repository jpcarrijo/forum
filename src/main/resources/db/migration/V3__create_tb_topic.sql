create table tb_topic(
    id    UUID primary key not null,
    title  varchar(100) not null,
    message varchar(500) not null,
    create_date timestamp not null,
    course_id UUID not null,
    user_id UUID not null,
    status varchar(20) not null
);

alter table tb_topic
    add constraint fk_tb_topic_user_id
        foreign key (user_id)
            references tb_user(id);

alter table tb_topic
    add constraint fk_tb_topic_course_id
        foreign key (course_id)
            references tb_course(id);