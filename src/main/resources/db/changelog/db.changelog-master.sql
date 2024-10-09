-- collapsed into 1 changeset for simplicity
create table Task
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    progress_status VARCHAR(50) not null,
    team_member_id BIGINT,
    fk_teammember BIGINT,

    constraint Task_pk
        primary key (id)
);

create table TeamMember
(
    id   BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    task_id BIGINT,

    constraint TeamMember_pk
        primary key (id)
);
