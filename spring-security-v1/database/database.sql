USE security;

INSERT INTO role(id, createdby, createddate, modifiedby, modifieddate, name)
    VALUE(uuid(), "SYSTEM", now(), "SYSTEM", now(), "ADMIN");
INSERT INTO role(id, createdby, createddate, modifiedby, modifieddate, name)
    VALUE(uuid(), "SYSTEM", now(), "SYSTEM", now(), "DRIVER");
INSERT INTO role(id, createdby, createddate, modifiedby, modifieddate, name)
    VALUE(uuid(), "SYSTEM", now(), "SYSTEM", now(), "USER");
INSERT INTO role(id, createdby, createddate, modifiedby, modifieddate, name)
    VALUE(uuid(), "SYSTEM", now(), "SYSTEM", now(), "GUEST");

INSERT INTO user(id, createdby, createddate, modifiedby, modifieddate, email, name, password, username)
    VALUE(uuid(), "SYSTEM", now(), "SYSTEM", now(), "quangntn0302@gmail.com", "Quang Nguyen", "123456", "quangnguyen");

INSERT INTO user_roles(user_id, role_id)
    VALUE("f49f9ae4-b37d-11eb-9a5c-53c6e7344fee", "f237b020-b37d-11eb-9a5c-53c6e7344fee")