package com.example.experience_platform.common;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.example.experience_platform.file.vo.FileVo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class FileUtils {

    // 물리적으로 파일을 저장할 위치 (C:\사용자\곽명아\springbootfile)
    private final String uploadPath = "C:\\사용자\\곽명아\\springbootfile";

    // 단일 파일 업로드
    public FileVo uploadFile(final MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            return null;
        }

        // 디스크(폴더)에 저장할 파일명
        String saveName = generateSaveFilename(multipartFile.getOriginalFilename());

        // 오늘날짜 (예: 251207)
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));

        // 오늘 날짜 폴더 경로 생성
        String fullUploadPath = getUploadPath(today) + File.separator + saveName;

        // 업로드할 경로의 파일 객체
        File uploadFile = new File(fullUploadPath);

        try {
            multipartFile.transferTo(uploadFile); // 파일 업로드
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return FileVo.builder() // 업로드 한 파일의 정보를 VO에 담음
                .originalName(multipartFile.getOriginalFilename())
                .saveName(saveName)
                .fileUrl("/uploads/" + today + "/" + saveName) // 실제 접근 가능한 URL
                .build();
    }

    // saveName 생성 (실제 저장될 파일명)
    private String generateSaveFilename(final String filename) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String extension = StringUtils.getFilenameExtension(filename);
        return uuid + "." + extension;
    }

    // 오늘 날짜 폴더 없으면 생성
    private String getUploadPath(final String addPath) {
        return makeDirectories(uploadPath + File.separator + addPath);
    }

    private String makeDirectories(final String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs(); // 폴더 없으면 생성
        }
        return dir.getPath();
    }
}