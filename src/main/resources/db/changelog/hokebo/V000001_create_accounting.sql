CREATE TABLE IF NOT EXISTS public.accounting
(
    id                      BIGSERIAL NOT NULL,
    created_on              timestamp  not null,
    created_by              varchar not null,
    changed_on              timestamp,
    changed_by              varchar not null,

    CONSTRAINT accounting_pk PRIMARY KEY (id)
);