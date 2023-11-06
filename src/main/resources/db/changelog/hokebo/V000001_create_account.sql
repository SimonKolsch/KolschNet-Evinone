CREATE TABLE IF NOT EXISTS public.account
(
    id                      BIGSERIAL NOT NULL,
    owner                   varchar not null,
    iban                    varchar(22) not null,
    created_date            timestamp  not null,
    created_by              BIGSERIAL not null,
    last_modified_date      timestamp,
    last_modified_by        BIGSERIAL,

    CONSTRAINT account_pk PRIMARY KEY (id),
    CONSTRAINT account_iban_ui unique nulls not distinct(iban)
);

