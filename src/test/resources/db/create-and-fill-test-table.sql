create table test.subject_test
(
    id          int primary key auto_increment,
    name        varchar(255),
    comment     text,
    amount      int,
    create_date datetime,
    update_date datetime
);

insert into test.subject_test (id, name, comment, amount, create_date, update_date)
values (1, '1',     'one',     1,    curdate(),     null),
       (2, '2',     'two',     2,    curdate(),     null),
       (3, '3',     'three',   3,    curdate(),     null),
       (4, '4',     'four',    4,    curdate(),     null),
       (5, '5',     'five',    5,    curdate(),     null),
       (6, '6',     'six',     6,    curdate(),     null),
       (7, '7',     'seven',   7,    curdate(),     null),
       (8, '8',     'eight',   8,    curdate(),     null),
       (9, '9',     'nine',    9,    curdate(),     null),
       (10, '10',   'ten',     10,   curdate(),     null);