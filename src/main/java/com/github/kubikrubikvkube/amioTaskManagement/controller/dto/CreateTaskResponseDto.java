package com.github.kubikrubikvkube.amioTaskManagement.controller.dto;

import com.github.kubikrubikvkube.amioTaskManagement.dto.TaskDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(name = "Ответ на запрос создания задачи")
public class CreateTaskResponseDto {

    private final TaskDto taskDto;
    private final LocalDateTime timestamp;

    public CreateTaskResponseDto(TaskDto taskDto) {
        this.taskDto = taskDto;
        this.timestamp = LocalDateTime.now();
    }
}
