package com.github.kubikrubikvkube.amioTaskManagement.util;

import com.github.kubikrubikvkube.amioTaskManagement.dto.TaskDto;
import com.github.kubikrubikvkube.amioTaskManagement.entity.TaskProgressStatus;

public class MockUtils {

    private MockUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static TaskDto taskDto() {
        return new TaskDto("name", TaskProgressStatus.NEW);
    }

}
