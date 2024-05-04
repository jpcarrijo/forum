create table tb_answers(
    id    UUID primary key not null,
    message varchar(500) not null,
    create_date timestamp not null,
    user_id UUID not null,
    topic_id UUID not null,
    solution smallint not null
);

alter table tb_answers
    add constraint fk_tb_answers_user_id
        foreign key (user_id)
            references tb_user(id);

alter table tb_answers
    add constraint fk_tb_answers_topic_id
        foreign key (topic_id)
            references tb_topic(id);