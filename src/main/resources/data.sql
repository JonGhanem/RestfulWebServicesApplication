
insert into user_details(id,birth_date,name)
values(10001, current_date(),'Yahya');

insert into user_details(id,birth_date,name)
values(10002, current_date(),'Mohamed');

insert into user_details(id,birth_date,name)
values(10003, current_date(),'Youssef');



insert into post(id,description,user_id)
values(20001,'Yahya want to learn AWS', 10001);

insert into post(id,description,user_id)
values(20002,'Yahya want to learn DevOps', 10001);

insert into post(id,description,user_id)
values(20003,'Mohamed want to Get AWS Certified', 10002);

insert into post(id,description,user_id)
values(20004,'Mohamed want to learn Multi Cloud', 10002);


insert into post(id,description,user_id)
values(20005,'Youusef want to Get AWS Certified', 10003);

insert into post(id,description,user_id)
values(20006,'Youusef want to learn Multi Cloud', 10003);