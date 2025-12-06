package com.example.experience_platform.campaign.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CampaignVo {
    private Long campaignId; // 캠페인 ID 시퀀스
    private Long categoryId; // 카테고리
    private String adminId; // 관리자 아이디
    private String content; // 내용
    private String imageUrl; // 이미지 url
    private Date recruitStart; // 모집시작일
    private Date recruitEnd; // 모집마감일
    private String status; // 상태
    private Date createdAt; // 작성일
    private String storeName; // 업체명
    private String storePhone; // 업체번호
    private String storeAddress; // 업체주소
    private long maxApply; // 모집인원


}
