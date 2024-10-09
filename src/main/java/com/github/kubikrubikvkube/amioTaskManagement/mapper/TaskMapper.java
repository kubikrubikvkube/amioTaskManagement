package com.github.kubikrubikvkube.amioTaskManagement.mapper;

import com.github.kubikrubikvkube.amioTaskManagement.dto.TaskDto;
import com.github.kubikrubikvkube.amioTaskManagement.entity.Task;
import io.swagger.v3.oas.annotations.media.Schema;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task task);
}
