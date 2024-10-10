package com.github.kubikrubikvkube.amioTaskManagement.controller;

import com.github.kubikrubikvkube.amioTaskManagement.controller.dto.CreateTaskRequestDto;
import com.github.kubikrubikvkube.amioTaskManagement.entity.TaskProgressStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CreateTaskTest {

    @Autowired
    TaskController taskController;

    @Test
    @DisplayName("Задача создана успешно, возвращен ответ корректного формата из контроллера")
    public void testCreateTask() {
        var request = new CreateTaskRequestDto();
        request.setName("test");

        var createdTask = taskController.createTask(request);

        assertThat(createdTask)
                .isNotNull()
                .hasFieldOrProperty("taskDto")
                .hasFieldOrProperty("timestamp");

        var taskDto = createdTask.getTaskDto();
        var timestamp = createdTask.getTimestamp();


        assertThat(taskDto.getName()).isEqualTo("test");
        assertThat(taskDto.getProgressStatus()).isEqualTo(TaskProgressStatus.NEW);
        assertThat(timestamp).isNotNull();

    }
}
