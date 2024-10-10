package com.github.kubikrubikvkube.amioTaskManagement.service;

import com.github.kubikrubikvkube.amioTaskManagement.controller.dto.CreateTaskRequestDto;
import com.github.kubikrubikvkube.amioTaskManagement.dto.TaskDto;
import com.github.kubikrubikvkube.amioTaskManagement.entity.Task;
import com.github.kubikrubikvkube.amioTaskManagement.mapper.TaskMapper;
import com.github.kubikrubikvkube.amioTaskManagement.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Сервис для работы с задачами
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskMapper taskMapper;
    private final TaskRepository repository;


    public TaskDto createTask(CreateTaskRequestDto taskDto) {

        log.info("Creating task from request {}", taskDto);
        Task task = new Task();
        task.setName(taskDto.getName());
        Task savedTask = repository.save(task);
        log.info("Saved task: {}", savedTask);

        return taskMapper.toDto(savedTask);
    }
}
