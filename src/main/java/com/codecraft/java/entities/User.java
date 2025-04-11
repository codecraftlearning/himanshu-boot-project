package com.codecraft.java.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersistDate() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}
