package com.github.kubikrubikvkube.amioTaskManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Table(name = "TASK")
public class Task {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private TaskProgressStatus progressStatus = TaskProgressStatus.NEW;

    @ManyToOne
    @JoinColumn(name = "fk_teammember")
    private TeamMember teamMembers;

}