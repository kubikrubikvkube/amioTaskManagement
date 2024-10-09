package com.github.kubikrubikvkube.amioTaskManagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * DTO члена команды
 */
@Data
@RequiredArgsConstructor
public class TeamMemberDto {

    /**
     * Имя члена команды
     */
    private final String name;

    /**
     * Задачи в работе у члена команды
     */
    private List<TaskDto> tasks;
}
