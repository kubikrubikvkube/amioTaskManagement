package com.github.kubikrubikvkube.amioTaskManagement.service;

import com.github.kubikrubikvkube.amioTaskManagement.controller.dto.CreateTeamMemberRequestDto;
import com.github.kubikrubikvkube.amioTaskManagement.dto.TeamMemberDto;
import com.github.kubikrubikvkube.amioTaskManagement.repository.TeamMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TeamMemberServiceTest {

    @Autowired
    TeamMemberService teamMemberService;

    @Autowired
    TeamMemberRepository teamMemberRepository;

    @Test
    @DisplayName("Член команды сохраняется в репозиторий по запросу")
    void create() {

        assertThat(teamMemberRepository.count()).isEqualTo(0);

        CreateTeamMemberRequestDto requestDto = new CreateTeamMemberRequestDto("test");
        TeamMemberDto teamMemberDto = teamMemberService.create(requestDto);

        assertThat(teamMemberDto).isNotNull()
                .hasFieldOrProperty("name")
                .hasFieldOrProperty("tasks");

        assertThat(teamMemberRepository.count()).isEqualTo(1);
    }
}