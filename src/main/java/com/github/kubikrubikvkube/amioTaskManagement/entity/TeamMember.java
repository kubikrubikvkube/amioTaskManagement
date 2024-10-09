package com.github.kubikrubikvkube.amioTaskManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Table(name = "TEAMMEMBER")
public class TeamMember {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private Long taskId;

    @OneToMany(mappedBy = "teamMembers")
    private List<Task> tasks;
}