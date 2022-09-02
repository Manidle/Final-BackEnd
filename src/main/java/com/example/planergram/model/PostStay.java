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
@Table(name = "post_stay")
public class PostStay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_stay_like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Stay.class)
    @JoinColumn(name = "stay_id")
    private Stay stay;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Post.class)
    @JoinColumn(name = "post_id")
    private Post post;
}
