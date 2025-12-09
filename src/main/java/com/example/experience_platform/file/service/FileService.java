package com.example.experience_platform.file.service;

import com.example.experience_platform.file.mapper.FileMapper;
import com.example.experience_platform.file.vo.FileVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FileService {
    @Autowired
    private FileMapper fileMapper;

    public void saveFile(FileVo vo){
        fileMapper.insertFile(vo);
    }

    public List<FileVo> getFiles(Long campaignId){
        return fileMapper.getFilesByCampaignId(campaignId);
    }

    
}
