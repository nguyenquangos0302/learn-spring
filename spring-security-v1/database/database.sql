CREATE
DATABASE security;

USE
security;

INSERT INTO Role(id, createdby, createddate, modifiedby, modifieddate, name)
    VALUE(uuid(), "SYSTEM", now(), "SYSTEM", now(), "ADMIN");
INSERT INTO Role(id, createdby, createddate, modifiedby, modifieddate, name)
    VALUE(uuid(), "SYSTEM", now(), "SYSTEM", now(), "DRIVER");
INSERT INTO Role(id, createdby, createddate, modifiedby, modifieddate, name)
    VALUE(uuid(), "SYSTEM", now(), "SYSTEM", now(), "USER");
INSERT INTO Role(id, createdby, createddate, modifiedby, modifieddate, name)
    VALUE(uuid(), "SYSTEM", now(), "SYSTEM", now(), "GUEST");