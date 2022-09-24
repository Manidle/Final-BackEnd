package com.example.planergram.postTravel.model;

import com.example.planergram.travelContents.model.Train;
import com.example.planergram.post.model.Post;
import io.swagger.annotations.ApiModelProperty;
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

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Train.class)
    @JoinColumn(name = "train_id")
    private Train train;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Post.class)
    @JoinColumn(name = "post_id")
    private Post post;

    @ApiModelProperty(value = "출발역", example = "서울")
    private String depplacename;

    @ApiModelProperty(value = "도착역", example = "대전")
    private String arrplacename;

    @ApiModelProperty(value = "출발시간", example = "20210505051500")
    private String depplandtime;

    @ApiModelProperty(value = "도착시간", example = "20210505061200")
    private String arrplandtime;

    @ApiModelProperty(value = "요금", example = "23700")
    private int adultcharge;

    @ApiModelProperty(value = "기차번호", example = "1")
    private int trainno;
}
