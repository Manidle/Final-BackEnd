package com.example.planergram.postTravel.model;

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
@Table(name = "post_train")
public class PostTrain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_train_id")
    private Long postTrainId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Post.class)
    @JoinColumn(name = "post_id")
    private Post post;

    private String depplacename;
    private String depplaceNodeName;
    private String arrplacename;
    private String arrplaceNodeName;
    private String depplandtime;
    private String arrplandtime;
    private int adultcharge;
    private int trainno;
}
