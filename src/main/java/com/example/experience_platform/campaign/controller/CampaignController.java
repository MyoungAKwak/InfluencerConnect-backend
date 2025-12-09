package com.example.experience_platform.campaign.controller;

import com.example.experience_platform.campaign.service.CampaignService;
import com.example.experience_platform.campaign.vo.CampaignVo;
import com.example.experience_platform.file.vo.FileVo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.example.experience_platform.common.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/campaign")
public class CampaignController {
    private final CampaignService campaignService;
    private final FileUtils fileUtils;

    public CampaignController(CampaignService campaignService, FileUtils fileUtils) {
        this.campaignService = campaignService;
        this.fileUtils = fileUtils;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createCampaign(
            @ModelAttribute CampaignVo campaignVo,
            @RequestParam(value = "thumbnail", required = false) MultipartFile file) {

        int result = campaignService.createCampaign(campaignVo, file);

        if (result != 1) {
            return ResponseEntity.status(500).body("campaign creation failed");
        }
        return ResponseEntity.ok("success");
    }
        // DB 저장 로직
        // 예: campaignMapper.insertCampaign(campaignVo);
        // 여기서 campaignVo에는 imageUrl이 파일명으로 들어감

}
