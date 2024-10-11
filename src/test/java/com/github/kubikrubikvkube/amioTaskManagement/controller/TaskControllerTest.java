package com.github.kubikrubikvkube.amioTaskManagement.controller;

import com.github.kubikrubikvkube.amioTaskManagement.service.TaskService;
import com.github.kubikrubikvkube.amioTaskManagement.util.MockUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    TaskController taskController;

    @MockBean
    TaskService taskService;

    @Autowired
    MockMvc mockMvc;


    @Test
    @DisplayName("Валидный запрос пробрасывается в сервис")
    void createTask_valid() throws Exception {
        when(taskService.createTask(any())).thenReturn(MockUtils.taskDto());

        mockMvc.perform(
                post("/api/task")
                        .accept(APPLICATION_JSON)
                        .contentType(APPLICATION_JSON)
                        .content("""
                                {
                                    "name": "test"
                                }
                                """)
        ).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Невалидный запрос отдаёт ошибку")
    void createTask_invalid() throws Exception {

        mockMvc.perform(
                post("/api/task")
                        .accept(APPLICATION_JSON)
                        .contentType(APPLICATION_JSON)
                        .content("""
                                {
                                    "invalid": "invalid"
                                }
                                """)
        ).andExpect(status().isBadRequest());
    }

}