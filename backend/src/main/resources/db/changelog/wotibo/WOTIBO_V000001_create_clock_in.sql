CREATE SCHEMA IF NOT EXISTS wotibo;

CREATE TABLE IF NOT EXISTS wotibo.clock_in
(
    id                      BIGSERIAL NOT NULL,
    owner                   varchar not null,
    clock_in                timestamp not null,
    status_flag             VARCHAR(1) not null default 'O',
    created_on              timestamp not null,
    created_by              bigint  not null,
    last_modified_on        timestamp,
    last_modified_by        bigint,

    CONSTRAINT clock_in_pk PRIMARY KEY (id)
);

