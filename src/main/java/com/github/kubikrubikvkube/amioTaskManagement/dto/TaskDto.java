package com.github.kubikrubikvkube.amioTaskManagement.dto;

import com.github.kubikrubikvkube.amioTaskManagement.entity.TaskProgressStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * DTO задачи
 */
@Data
@RequiredArgsConstructor
public class TaskDto {

    /**
     * Имя задачи
     */
    private final String name;

    /**
     * Статус работы над задачей
     */
    private final TaskProgressStatus progressStatus;

}
