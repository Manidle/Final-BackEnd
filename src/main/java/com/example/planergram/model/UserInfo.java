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
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_info_id")
    private Long id;

    @Column(name = "profile_img", length = 30)
    private String profileImg;

    @Column(name = "email", nullable = false,length = 30, unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "id")
    private User user;
}
