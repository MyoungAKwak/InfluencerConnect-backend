package com.example.experience_platform.campaign.service;

import com.example.experience_platform.board.mapper.BoardMapper;
import com.example.experience_platform.campaign.mapper.CampaignMapper;
import com.example.experience_platform.campaign.vo.CampaignVo;
import org.springframework.stereotype.Service;

@Service

public class CampaignService {
    private final CampaignMapper campaignMapper;

    public CampaignService(CampaignMapper campaignMapper) {
        this.campaignMapper = campaignMapper;
    }

    // 캠페인 등록
    public int createCampaign(CampaignVo campaignVo){
        return campaignMapper.insert(campaignVo);
    }

}
