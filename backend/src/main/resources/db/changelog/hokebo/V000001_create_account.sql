CREATE TABLE IF NOT EXISTS public.account
(
    id                      BIGSERIAL NOT NULL,
    owner                   varchar not null,
    iban                    varchar(22) not null,
    created_on              timestamp  not null,
    created_by              bigint  not null,
    last_modified_on        timestamp,
    last_modified_by        bigint,

    CONSTRAINT account_pk PRIMARY KEY (id),
    CONSTRAINT account_iban_ui unique nulls not distinct(iban)
);

