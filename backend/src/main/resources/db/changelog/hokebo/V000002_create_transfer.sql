CREATE TABLE IF NOT EXISTS public.transfer
(
    id                      BIGSERIAL NOT NULL,
    credit_account_id       BIGINT not null,
    debit_account_id        BIGINT not null,
    value                   numeric not null,
    currency                varchar(3) not null,
    reference               varchar,
    invoice_date            timestamp not null,
    processed               boolean not null default false,
    created_on              timestamp  not null,
    created_by              bigint  not null,
    last_modified_on        timestamp,
    last_modified_by        bigint ,

    CONSTRAINT transfer_pk PRIMARY KEY (id)

);

alter table transfer
    add constraint transfer_creditAccountId_fk
        foreign key (credit_account_id) references public.account;
alter table transfer
    add constraint transfer_debitAccountId_fk
        foreign key (debit_account_id) references public.account;

