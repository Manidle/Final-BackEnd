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
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String title;

    @Lob //대용량 데이터
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userid")
    private User user;
}
