package com.example.planergram.userLike.model;

import com.example.planergram.post.model.Post;
import com.example.planergram.user.model.User;
import lombok.*;

import javax.persistence.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Entity
@Table(name = "post_like")
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Post.class)
    @JoinColumn(name = "post_id")
    private Post post;
}
