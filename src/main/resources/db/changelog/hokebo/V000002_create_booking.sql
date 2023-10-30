CREATE TABLE IF NOT EXISTS public.booking
(
    id                      BIGSERIAL NOT NULL,
    credit_account_id       BIGINT not null,
    debit_account_id        BIGINT not null,
    amount                  numeric not null,
    currency                char(3) not null,
    created_on              timestamp  not null,
    created_by              varchar not null,
    changed_on              timestamp,
    changed_by              varchar not null,

    CONSTRAINT booking_pk PRIMARY KEY (id)

);

alter table booking
    add constraint booking_credit_account_id_fk
        foreign key (credit_account_id) references public.account;
alter table booking
    add constraint booking_debit_account_id_fk
        foreign key (debit_account_id) references public.account;

