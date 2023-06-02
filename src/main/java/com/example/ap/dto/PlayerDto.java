package com.example.ap.dto;

import com.example.ap.entity.Gender;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

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

    private List<SportsDto> sports;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<SportsDto> getSports() {
        return sports;
    }

    public void setSports(List<SportsDto> sports) {
        this.sports = sports;
    }
}
