package com.example.experience_platform.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardVo {
    private Long boardId; // 오토
    private Long userId; // 작성자 ID
    private String title; // 제목
    private String content; // 내용
    private Date createdAt; // 작성일
}
