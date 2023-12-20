insert into account (owner, iban, created_date, created_by)
values ('owner', 'iban', now(), 1);

insert into account (owner, iban, created_date, created_by, last_modified_date, last_modified_by)
values ('owner1', 'iban567890123456789212', now(), 1, now(), 1);

insert into account (owner, iban, created_date, created_by, last_modified_date, last_modified_by)
values ('owner1', 'test567890123456789212', now(), 1, now(), 1);
