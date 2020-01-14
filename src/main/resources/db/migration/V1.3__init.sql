insert into USERS(ID, USER_CODE, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, USER_COMPANY_CODE, PHONE_NUMBER, EMAIL,
                  DESCRIPTION, CREATED_BY, LAST_UPDATED_BY)
values (1, 'COD0001', 'admin', '$2a$10$AZ1ERMYv0FJZ5YodE0iTpuiDtBwJuKACxk8xWElv9/cAbal0pN6xC',
        'admin', 'admin', 'CODE', '1234567891', 'admin@gmail.com', 'demo admin', 1, 1),
       (2, 'COD0002', 'user', '$2a$10$AZ1ERMYv0FJZ5YodE0iTpuiDtBwJuKACxk8xWElv9/cAbal0pN6xC',
        'admin', 'admin', 'CODE', '1234567891', 'user@gmail.com', 'demo admin', 1, 1);

#init Permission
insert into PERMISSIONS(ID, NAME, CODE, PERMISSION_TYPE, DESCRIPTION, CREATED_BY, LAST_UPDATED_BY)
values (1, 'admin', 'ADM00001', 1, 'ADMIN', 1, 1),
       (2, 'user', 'USER00001', 1, 'USER', 1, 1);