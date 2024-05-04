create table tb_course(
    id       UUID primary key not null,
    name     varchar(100) not null,
    category varchar(100) not null
);

insert into tb_course(id, name, category) values('0426c4b6-a62a-46d3-8f3d-734840582af6', 'Kotlin', 'Programação');
insert into tb_course(id, name, category) values('66a32482-726d-4107-a18e-34dfc3170c35', 'Java', 'Programação');