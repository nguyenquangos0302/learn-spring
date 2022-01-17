CREATE
DATABASE security;

USE
security;

INSERT INTO role(id, createdby, createddate, lastmidifiedby, lastmodifieddate, name)
    VALUE("ce12db56-e18c-11eb-9f93-8d35624d5de7", "SYSTEM", now(), "SYSTEM", now(), "ADMIN");
INSERT INTO role(id, createdby, createddate, lastmidifiedby, lastmodifieddate, name)
    VALUE("ce13b9ea-e18c-11eb-9f93-8d35624d5de7", "SYSTEM", now(), "SYSTEM", now(), "DRIVER");
INSERT INTO role(id, createdby, createddate, lastmidifiedby, lastmodifieddate, name)
    VALUE("ce13e8fc-e18c-11eb-9f93-8d35624d5de7", "SYSTEM", now(), "SYSTEM", now(), "USER");
INSERT INTO role(id, createdby, createddate, lastmidifiedby, lastmodifieddate, name)
    VALUE("ce14149e-e18c-11eb-9f93-8d35624d5de7", "SYSTEM", now(), "SYSTEM", now(), "GUEST");

INSERT INTO user(id, createdby, createddate, lastmidifiedby, lastmodifieddate, email, name, password, username)
    VALUE("d01933b4-e18c-11eb-9f93-8d35624d5de7", "SYSTEM", now(), "SYSTEM", now(), "quangntn0302@gmail.com", "Quang Nguyen", "$2a$10$MEafZZgRwiIYJM./kT1gteNdg.A2fS0kTXqOfwwUb4U8DgQVAOKIC", "quangnguyen");

INSERT INTO user_roles(user_id, role_id)
    VALUE("d01933b4-e18c-11eb-9f93-8d35624d5de7", "ce12db56-e18c-11eb-9f93-8d35624d5de7");

INSERT INTO phone(id, createdby, createddate, lastmidifiedby, lastmodifieddate, number, region, user_id)
    value("808d1b64-ec8e-11eb-90c7-51b596d15538", "SYSTEM", now(), "SYSTEM", now(), "0902498522", "VN", "d01933b4-e18c-11eb-9f93-8d35624d5de7");