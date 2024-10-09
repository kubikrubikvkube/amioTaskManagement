package com.github.kubikrubikvkube.amioTaskManagement.controller;

import com.github.kubikrubikvkube.amioTaskManagement.controller.dto.CreateTaskRequestDto;
import com.github.kubikrubikvkube.amioTaskManagement.controller.dto.CreateTaskResponseDto;
import com.github.kubikrubikvkube.amioTaskManagement.controller.service.TaskService;
import com.github.kubikrubikvkube.amioTaskManagement.dto.TaskDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

@RestController
@RequiredArgsConstructor
@Tag(name = "Задачи API")
public class TaskController {

    private final TaskService taskService;

    @Operation(summary = "Создание задачи")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Задача создана",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreateTaskResponseDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера",
                    content = @Content) })
    @PostMapping("api/task/create")
    public CreateTaskResponseDto createTask(@Valid @RequestBody CreateTaskRequestDto requestDto) {
        TaskDto taskDto = taskService.createTask(requestDto);
        return new CreateTaskResponseDto(taskDto);
    }
}
