CREATE TABLE IF NOT EXISTS public.transactions
(
    id                      BIGSERIAL NOT NULL,
    credit_account_id       BIGINT not null,
    debit_account_id        BIGINT not null,
    amount                  numeric not null,
    currency                varchar(3) not null,
    created_date            timestamp  not null,
    created_by              bigint  not null,
    last_modified_date      timestamp,
    last_modified_by        bigint ,

    CONSTRAINT transactions_pk PRIMARY KEY (id)

);

alter table transactions
    add constraint booking_credit_account_id_fk
        foreign key (credit_account_id) references public.account;
alter table transactions
    add constraint booking_debit_account_id_fk
        foreign key (debit_account_id) references public.account;

