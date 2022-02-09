package com.example.redditclone.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    private String username;
    private String email;
    private String password;
    private Instant createdAt;

    @Enumerated(EnumType.STRING)
    private RoleType role;
}
