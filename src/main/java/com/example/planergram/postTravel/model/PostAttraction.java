package com.example.planergram.postTravel.model;

import com.example.planergram.travelContents.model.Attraction;
import com.example.planergram.post.model.Post;
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

    private String name;
    private String address;
    private String description;
    private int price;
    private int likeCount;
}
