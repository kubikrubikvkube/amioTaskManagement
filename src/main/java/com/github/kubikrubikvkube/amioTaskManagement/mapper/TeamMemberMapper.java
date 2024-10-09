package com.github.kubikrubikvkube.amioTaskManagement.mapper;

import com.github.kubikrubikvkube.amioTaskManagement.dto.TeamMemberDto;
import com.github.kubikrubikvkube.amioTaskManagement.entity.TeamMember;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMemberMapper {

    TeamMemberDto toDto(TeamMember teamMember);
}
