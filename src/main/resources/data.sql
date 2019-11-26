insert into users(user_id, username, password)
		values
        (1, "kiran", "$2a$10$QCOXueElj1XMzqXY2PB/8OmkHQOkBK5o/RAzGpI5R4HiTur/V8TcW"),
        (2, "vinay", "$2a$10$cLAm1dcOwXKXWKEkxwf/3uFs52ls6k4EFzlhgMnleiUKDcfxW5UFm");

insert into roles (role_id, role_name)
     values
     (1, "USER"),
     (2, "ADMIN");

insert into users_roles (user_id, role_id)
    values
    (1,1),
    (2, 2);
