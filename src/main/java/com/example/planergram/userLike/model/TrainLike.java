package com.example.planergram.userLike.model;

import com.example.planergram.user.model.User;
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
@Table(name = "train_like")
public class TrainLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_like_id")
    private Long trainLikeId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

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
