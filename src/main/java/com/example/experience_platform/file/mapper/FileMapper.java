package com.example.experience_platform.file.mapper;

import com.example.experience_platform.file.vo.FileVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
    // 파일 저장
    int insertFile(FileVo fileVo);

    // campaign_id 기준 파일 목록 조회
    List<FileVo> getFilesByCampaignId(Long campaignId);
}
