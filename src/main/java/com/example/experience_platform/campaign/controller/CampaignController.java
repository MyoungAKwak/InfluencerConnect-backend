package com.example.experience_platform.campaign.controller;

import com.example.experience_platform.campaign.service.CampaignService;
import com.example.experience_platform.campaign.vo.CampaignVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/campaign")
public class CampaignController {
    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService){
        this.campaignService = campaignService;
    }

    //캠페인 생성
    @PostMapping
    public String createCampaign(@RequestBody CampaignVo campaignVo) {
        return campaignService.createCampaign(campaignVo) == 1 ? "캠페인 등록 성공" : "캠페인 등록 실패 ";
    }
}
