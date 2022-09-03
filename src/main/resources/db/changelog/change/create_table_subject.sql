create table subject(
    id int primary key auto_increment,
    name varchar(255),
    comment text,
    amount int,
    create_date datetime,
    update_date datetime
)