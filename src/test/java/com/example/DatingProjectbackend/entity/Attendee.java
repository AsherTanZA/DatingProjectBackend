package com.example.DatingProjectbackend.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "attendees")

public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id", nullable = false, unique = true )
    private String email;

    @Enumerated(EnumType.STRING)  // Stores as "MALE" or "FEMALE"
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @ElementCollection
    @CollectionTable(name = "attendee_hobbies", joinColumns = @JoinColumn(name = "attendee_id"))
    @Column(name = "hobby")
    private List<String> hobbies;

    @Enumerated(EnumType.STRING)  // Stores as only the 5 love languages
    @Column(name = "love_language")
    private Lovelanguage loveLanguage;

    @Column(name = "personality_type")
    private String personalityType;

    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

}
