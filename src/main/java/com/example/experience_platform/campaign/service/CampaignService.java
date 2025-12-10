package com.example.experience_platform.campaign.service;

import com.example.experience_platform.campaign.mapper.CampaignMapper;
import com.example.experience_platform.campaign.vo.CampaignVo;
import com.example.experience_platform.common.FileUtils;
import com.example.experience_platform.file.mapper.FileMapper;
import com.example.experience_platform.file.vo.FileVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
@Service
public class CampaignService {

    private final CampaignMapper campaignMapper;
    private final FileMapper fileMapper;
    private final FileUtils fileUtils;

    public CampaignService(CampaignMapper campaignMapper, FileMapper fileMapper, FileUtils fileUtils) {
        this.campaignMapper = campaignMapper;
        this.fileMapper = fileMapper;
        this.fileUtils = fileUtils;
    }

    public int createCampaign(CampaignVo vo, MultipartFile multipartFile) {

        int result = campaignMapper.insert(vo);
        Long campaignId = vo.getCampaignId();
        if(result != 1) return 0;

        if(multipartFile == null || multipartFile.isEmpty()) return 1;

        FileVo savedFile = fileUtils.uploadFile(multipartFile);
        // 1. Campaign insert 후 campaignId 받아오기


        // 2. FileVo에 campaignId 넣기
        FileVo fileVo = new FileVo();
        fileVo.setCampaignId(vo.getCampaignId());
        fileVo.setSaveName(savedFile.getSaveName());
        fileVo.setOriginalName(savedFile.getOriginalName());
        fileVo.setFileUrl(savedFile.getFileUrl());
        fileVo.setUploadedAt(new Date());

        // 3. File insert
        fileMapper.insertFile(fileVo);

        return 1;
    }

    //전체 캠페인 조회
    public List<CampaignVo> getAllCampaigns() {
        return campaignMapper.selectAll();
    }
}

