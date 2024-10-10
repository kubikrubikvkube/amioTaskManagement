package com.github.kubikrubikvkube.amioTaskManagement.controller.dto;

import com.github.kubikrubikvkube.amioTaskManagement.dto.TeamMemberDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(name = "Ответ на запрос создания члена команды")
public class CreateTeamMemberResponseDto {

    private final TeamMemberDto teamMember;
    private final LocalDateTime timestamp;
}
