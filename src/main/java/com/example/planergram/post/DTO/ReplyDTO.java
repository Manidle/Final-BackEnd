package com.example.planergram.post.DTO;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ReplyDTO {
    private Long replyId;
    private Long userId;
    private Long postId;
    private String contents;
    private String nickName;
}
