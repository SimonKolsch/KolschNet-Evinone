CREATE TABLE IF NOT EXISTS public.account_value
(
    id                      BIGSERIAL NOT NULL,
    account_id              BIGINT not null,
    accounting_date         date not null,
    value                   numeric not null,
    currency                varchar(3) not null,
    created_on              timestamp  not null,
    created_by              bigint  not null,

    CONSTRAINT accountValue_pk PRIMARY KEY (id)

);

alter table account_value
    add constraint accountValue_account_id_fk
        foreign key (account_id) references public.account;

