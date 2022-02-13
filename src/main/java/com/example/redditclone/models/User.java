package com.example.redditclone.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Entity
@Data
@Table(name ="_users", uniqueConstraints = @UniqueConstraint(columnNames={"username", "email"}))
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @NotBlank(message="Username is required")
    private String username;

    @Email
    @NotEmpty(message="Email is required")
    private String email;

    @NotBlank(message="Password is required")
    private String password;
    private Instant createdAt;
}
