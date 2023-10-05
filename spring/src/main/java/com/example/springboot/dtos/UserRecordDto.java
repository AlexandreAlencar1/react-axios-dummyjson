package com.example.springboot.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class UserRecordDto {
    private Long idUser;
    @Size(max = 255, message = "O nome deve ter no máximo 255 caracteres")
    private String name;

    @Email(message = "O formato do e-mail é inválido")
    @Size(max = 255, message = "O e-mail deve ter no máximo 255 caracteres")
    private String email;
    private String senha;
}
