-- collapsed into 1 changeset for simplicity
create table Task
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    progress_status VARCHAR(50) not null,
    team_member_id BIGINT,
    fk_teammember BIGINT,

    CONSTRAINT Task_pk
        PRIMARY KEY (id)
);

CREATE TABLE TeamMember
(
    id   BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    task_id BIGINT,

    CONSTRAINT TeamMember_pk
        PRIMARY KEY (id)

);

ALTER TABLE TeamMember
    ADD CONSTRAINT task_id_uq UNIQUE (task_id);

ALTER TABLE Task
    ADD FOREIGN KEY (team_member_id) REFERENCES TeamMember(task_id)