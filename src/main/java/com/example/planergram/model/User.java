package com.example.planergram.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id", nullable = false,length = 30, unique = true)
    private String userId;

    @Column(nullable = false,length = 100)
    private String password;

    @Column(nullable = false,length = 50)
    private String email;
}
