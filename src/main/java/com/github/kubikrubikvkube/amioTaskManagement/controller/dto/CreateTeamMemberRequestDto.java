package com.github.kubikrubikvkube.amioTaskManagement.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name = "Запрос создание члена команды")
public class CreateTeamMemberRequestDto {

    @NotBlank
    @Size(min = 1, max = 50, message = "Неверная длина имени члена команды")
    private final String name;
}
