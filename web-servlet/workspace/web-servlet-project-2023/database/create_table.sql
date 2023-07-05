use servlet_web_data;

CREATE TABLE role(
  id bigint NOT NULL PRIMARY KEY auto_increment,
  name VARCHAR(255) NOT NULL,
  code VARCHAR(255) NOT NULL,
  createddate TIMESTAMP NULL,
  modifieddate TIMESTAMP NULL,
  createdby VARCHAR(255) NULL,
  modifiedby VARCHAR(255) NULL
);

CREATE TABLE user (
  id bigint NOT NULL PRIMARY KEY auto_increment,
  username VARCHAR(150) NOT NULL,
  password VARCHAR(150) NOT NULL,
  fullname VARCHAR(150) NULL,
  status int NOT NULL,
  createddate TIMESTAMP NULL,
  modifieddate TIMESTAMP NULL,
  createdby VARCHAR(255) NULL,
  modifiedby VARCHAR(255) NULL,
  roleid bigint NOT NULL
);

ALTER TABLE user ADD CONSTRAINT fk_user_role FOREIGN KEY (roleid) REFERENCES role(id);

CREATE TABLE news(
id bigint NOT NULL PRIMARY KEY auto_increment,
title varchar (255) NULL,
thumbnail varchar(255) NULL,
shortdescription text NOT NULL,
content text NULL,
categoryid bigint not null,
createddate timestamp null,
modifieddate timestamp null,
createdby varchar(255) null,
modifiedby varchar(255) null
);

CREATE TABLE category(
id bigint NOT NULL PRIMARY KEY auto_increment,
name varchar (255) NULL,
code varchar(255) NULL,
createddate timestamp null,
modifieddate timestamp null,
createdby varchar(255) null,
modifiedby varchar(255) null
);

ALTER TABLE news ADD CONSTRAINT fk_news_category FOREIGN KEY (categoryid) REFERENCES category(id);

CREATE TABLE comment(
id bigint NOT NULL PRIMARY KEY auto_increment,
content text not NULL,
user_id bigint not null,
news_id bigint not null,
createddate timestamp null,
modifieddate timestamp null,
createdby varchar(255) null,
modifiedby varchar(255) null
);

ALTER TABLE comment ADD CONSTRAINT fk_comment_user FOREIGN KEY (user_id) REFERENCES user(id);
ALTER TABLE comment ADD CONSTRAINT fk_comment_news FOREIGN KEY (news_id) REFERENCES news(id);
