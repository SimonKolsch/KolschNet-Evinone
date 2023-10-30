CREATE TABLE IF NOT EXISTS public.account
(
    id                      BIGSERIAL NOT NULL,
    owner                   varchar not null,
    iban                    char(22) not null,
    created_on              timestamp  not null,
    created_by              varchar not null,
    changed_on              timestamp,
    changed_by              varchar not null,

    CONSTRAINT account_pk PRIMARY KEY (id),
    CONSTRAINT account_iban_ui unique nulls not distinct(iban)
);

