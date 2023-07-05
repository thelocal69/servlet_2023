use servlet_web_data;

INSERT INTO role(code, name) VALUES('ADMIN', 'Quản trị hệ thống');
INSERT INTO role(code, name) VALUES('USER', 'Người dùng');

INSERT INTO user(username, password, fullname, status, roleid) VALUES('admin', '123456', 'admin', 1, 1);
INSERT INTO user(username, password, fullname, status, roleid) VALUES('nguyenvana', '123456', 'Nguyễn Văn A', 1, 2);
INSERT INTO user(username, password, fullname, status, roleid) VALUES('nguyenvanb', '123456', 'Nguyễn Văn B', 1, 2);