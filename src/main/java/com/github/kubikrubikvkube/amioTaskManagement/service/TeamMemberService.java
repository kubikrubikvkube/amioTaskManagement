package com.github.kubikrubikvkube.amioTaskManagement.service;

import com.github.kubikrubikvkube.amioTaskManagement.controller.dto.CreateTeamMemberRequestDto;
import com.github.kubikrubikvkube.amioTaskManagement.dto.TeamMemberDto;
import com.github.kubikrubikvkube.amioTaskManagement.entity.TeamMember;
import com.github.kubikrubikvkube.amioTaskManagement.mapper.TeamMemberMapper;
import com.github.kubikrubikvkube.amioTaskManagement.repository.TeamMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Сервис для работы с членами команды
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TeamMemberService {

    private final TeamMemberRepository repository;
    private final TeamMemberMapper mapper;

    public TeamMemberDto create(CreateTeamMemberRequestDto request) {

        log.info("Creating TeamMemberDto from request {}", request);
        TeamMember teamMember = new TeamMember();
        teamMember.setName(request.getName());
        var savedTeamMember = repository.save(teamMember);
        log.info("Saved teamMember: {}", savedTeamMember);

        return mapper.toDto(savedTeamMember);
    }
}
