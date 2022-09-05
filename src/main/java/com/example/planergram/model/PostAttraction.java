package com.example.planergram.model;

import lombok.*;

import javax.persistence.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Entity
@Table(name = "post_attraction")
public class PostAttraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_attraction_id")
    private Long postAttractionId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Attraction.class)
    @JoinColumn(name = "attraction_id")
    private Attraction attraction;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Post.class)
    @JoinColumn(name = "post_id")
    private Post post;
}
