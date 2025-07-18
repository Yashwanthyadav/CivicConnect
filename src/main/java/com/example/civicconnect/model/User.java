package com.example.civicconnect.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String number;  // or use phoneNumber if preferred

    private String password;
    
    @Enumerated(EnumType.STRING)
    private Role role; // CITIZEN, ADMIN
}
