CREATE TABLE IF NOT EXISTS wotibo.timetable
(
    id                      BIGSERIAL NOT NULL,
    owner                   varchar not null,
    work_start              timestamp not null,
    work_end                timestamp not null,
    work_time               int not null,
    pause_time              int not null,
    created_on              timestamp not null,
    created_by              bigint  not null,
    last_modified_on        timestamp,
    last_modified_by        bigint,

    CONSTRAINT timetable_pk PRIMARY KEY (id)
);

