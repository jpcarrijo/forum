create table tb_user(
    id    UUID primary key not null,
    name  varchar(100) not null,
    email varchar(100) not null
);

insert into tb_user(id, name, email) values('909e8d3a-4f49-455b-8827-d5deab12d659','Ana Silva', 'silvaana@gmail.com');
insert into tb_user(id, name, email) values('66a32482-726d-4107-a18e-34dfc3170c35','Joao Silva', 'silvaJoao@gmail.com');
