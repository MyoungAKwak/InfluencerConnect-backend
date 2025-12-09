package com.example.experience_platform.file.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileVo {
    private Long fileId;  // 파일 ID
    private Long campaignId; // 캠페인 ID 저장! 중요
    private String originalName; 	// 원본 파일명
    private String saveName;		// 저장 파일명
    private String fileUrl; // 파일위치
    private Date uploadedAt; //파일 업로드날짜

}
