insert into transfer (credit_account_id,debit_account_id,value, currency, reference, invoice_date,created_on, created_by, last_modified_on, last_modified_by)
values (1,2, 10000, 'EUR', 'We love testing!', now(), now(), 1, now(), 1);

insert into transfer (credit_account_id,debit_account_id,value, currency, reference, invoice_date, created_on, created_by, last_modified_on, last_modified_by)
values (2,1, 10000, 'EUR', 'We don''t love testing!', now(), now(), 1, now(), 1);
