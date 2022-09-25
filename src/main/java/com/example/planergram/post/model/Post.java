package com.example.planergram.post.model;

import com.example.planergram.postTravel.model.PostAttraction;
import com.example.planergram.postTravel.model.PostRentCar;
import com.example.planergram.postTravel.model.PostStay;
import com.example.planergram.postTravel.model.PostTrain;
import com.example.planergram.user.model.User;
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
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @Column(nullable = false, length = 30)
    private String title;

    @Lob //대용량 데이터
    @Column(nullable = false, length = 30)
    private String contents;

    @Column(name = "like_count")
    private int likeCount;

    @Column(name = "read_count")
    private int readCount;

    private String nickname;

    private String boardName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reply> replyList;

    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PostStay> postStayList;

    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PostRentCar> postRentCarList;

    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PostTrain> postTrainList;

    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PostAttraction> postAttractionList;

//===============================================================================================
//================================활용 x 차후 Develop때 사용예정 ====================================
//================================================================================================

//    @Column(name = "detail_address")
//    private String detailAddress;
//
//    private String address;
}
