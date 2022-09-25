package com.example.planergram.postTravel.model;

import com.example.planergram.travelContents.model.Stay;
import com.example.planergram.post.model.Post;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

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
    @Column(name = "post_stay_id")
    private Long postStayId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Stay.class)
    @JoinColumn(name = "stay_id")
    private Stay stay;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Post.class)
    @JoinColumn(name = "post_id")
    private Post post;




    private String name;
    private String address;
    private int price;
    private LocalTime checkIn;
    private LocalTime checkOut;
    private int likeCount;
}
