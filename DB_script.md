```$xslt
use emp_db;

show tables;
insert into users(user_id, username, password)
		values 
        (1, "kiran", "encrption"),
        (2, "vinay", "encrption");
        
insert into roles (role_id, role_name)
     values 
     (1, "USER"),
     (2, "ADMIN");
     
insert into users_roles (user_id, role_id) 
    values 
    (1,1),
    (2, 2);
```