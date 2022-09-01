package com.example.planergram.DTO;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ReplyDTO {
    private Long replyId;
    private String contents;
    private Long userId;
    private Long postId;
}
