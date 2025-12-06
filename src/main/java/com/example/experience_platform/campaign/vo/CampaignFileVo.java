package com.example.experience_platform.campaign.vo;

import java.util.Date;

public class CampaignFileVo {
    private Long fileId; // 파일 ID
    private Long campaignId; // 캠페인ID와 연결
    private String fileName; // 파일명
    private String fileUrl; // 파일위치
    private Date uploadedAt; // 파일업로드날짜

}
