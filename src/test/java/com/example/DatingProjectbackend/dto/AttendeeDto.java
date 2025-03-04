package com.example.DatingProjectbackend.dto;

import com.example.DatingProjectbackend.entity.Gender;
import com.example.DatingProjectbackend.entity.Lovelanguage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttendeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private List<String> hobbies;
    private Lovelanguage loveLanguage;
    private String personalityType;

}
