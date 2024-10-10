package com.github.kubikrubikvkube.amioTaskManagement.controller;

import com.github.kubikrubikvkube.amioTaskManagement.controller.dto.CreateTaskRequestDto;
import com.github.kubikrubikvkube.amioTaskManagement.controller.dto.CreateTaskResponseDto;
import com.github.kubikrubikvkube.amioTaskManagement.service.TaskService;
import com.github.kubikrubikvkube.amioTaskManagement.dto.TaskDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.web.bind.annotation.*;

@Slf4j
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

    @PostMapping("api/task/assign/{teamMemberId}")
    public Object assignTask(@Valid @RequestBody CreateTaskRequestDto requestDto, @PathVariable Long teamMemberId) {
        log.info("Assign task by id");
        throw new NotImplementedException();
    }

    @GetMapping("api/task/{taskId}")
    public Object getTask(@PathVariable Long taskId) {
        log.info("Get task by id");
        throw new NotImplementedException();
    }


    @GetMapping("api/task/")
    public Object getAllTasks() {
        log.info("Get all task");
        throw new NotImplementedException();
    }

    @PutMapping("api/task/{taskId}")
    public Object updateTask(@PathVariable Long taskId) {
        log.info("Update task by id");
        throw new NotImplementedException();
    }

    @DeleteMapping("api/task/{taskId}")
    public Object deleteTask(@PathVariable Long taskId) {
        log.info("Delete task by id");
        throw new NotImplementedException();
    }


}
