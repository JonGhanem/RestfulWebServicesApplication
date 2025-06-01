package com.ghanem.RestfulWebServicesApplication.socialmedia.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "user_details")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(min = 3)
    @JsonProperty("user_name")
    private String name;
    @Past
    private LocalDate birthDate;
}
