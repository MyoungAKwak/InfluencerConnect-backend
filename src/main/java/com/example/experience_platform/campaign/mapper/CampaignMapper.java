package com.example.experience_platform.campaign.mapper;

import com.example.experience_platform.board.vo.BoardVo;
import com.example.experience_platform.campaign.vo.CampaignFileVo;
import com.example.experience_platform.campaign.vo.CampaignVo;
import com.example.experience_platform.file.vo.FileVo;

import java.util.List;

public interface CampaignMapper {

    int insert(CampaignVo campaignVo);
    int insertCampaignFile(FileVo fileVo);
    List<CampaignVo> selectAll();
}
