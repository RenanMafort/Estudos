insert into tb_user (name,email,password) VALUES ('Nina Brown', 'nina@gmail.com','$2a$10$yw2n0MFiuv3uDgXYbcb/a.GYSAejdyDQRbY5C6rHE/RGZExk1kUuG');
insert into tb_user (name,email,password) VALUES ('Renan Sereia', 'renansereia@gmail.com','$2a$10$wi23lE6XMdsTkeeJoxiAlue2GqQPDmV8V38m0AZfmxYjglBGVRpVK');

insert into tb_role (role_name) values ('ROLE_OPERATOR');
insert into tb_role (role_name) values ('ROLE_ADMIN');

insert into tb_users_role(user_id, role_id) values (1,1);
insert into tb_users_role(user_id, role_id) values (2,1);
insert into tb_users_role(user_id, role_id) values (2,2);