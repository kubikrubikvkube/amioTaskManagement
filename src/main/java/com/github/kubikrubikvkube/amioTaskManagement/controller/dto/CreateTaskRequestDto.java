package com.github.kubikrubikvkube.amioTaskManagement.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name = "Запрос на создание задачи")
public class CreateTaskRequestDto {

    @NotBlank
    @Size(min = 1, max = 50, message = "Неверная длина имени задачи")
    private String name;
}
