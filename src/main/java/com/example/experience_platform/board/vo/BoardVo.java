package com.example.experience_platform.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardVo {
    private Long boardId;
    //게시글마다 누가 작성했는지 알아야 하니까 userId 필요
    private Long userId;
    private String title;
    private String content;
    private Date createdAt;
}
