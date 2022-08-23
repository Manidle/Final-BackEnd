package com.example.planergram.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "username", nullable = false,length = 30, unique = true)
    private String username;

    @Column(nullable = false,length = 100)
    private String password;

    @Column(name = "nickname", nullable = false,length = 30, unique = true)
    private String nickname;

    @Column(nullable = false,length = 50)
    private String email;
}