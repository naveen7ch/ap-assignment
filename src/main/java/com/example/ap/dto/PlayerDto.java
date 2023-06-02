package com.example.ap.dto;

import com.example.ap.Gender;
import com.example.ap.entity.Sports;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
public class PlayerDto implements Serializable {
    private Long id;

    @NotNull
    @Size(max = 150)
    @Email
    private String email;

    @NotNull
    @Min(1)
    @Max(10)
    private Integer level;

    @Min(1)
    private Integer age;

    @NotNull
    private Gender gender;

    private Set<Sports> sports;
}
