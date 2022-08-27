package com.example.planergram.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "board_title", length = 100)
    private String title;

    @Lob //대용량 데이터
    @Column(name = "board_img", length = 100)
    private String img;

    @OneToMany(mappedBy = "board",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Post> postList; //게시글리스트
}