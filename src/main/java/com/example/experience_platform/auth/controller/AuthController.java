package com.example.experience_platform.auth.controller;

import com.example.experience_platform.auth.dto.LoginRequestDto;
import com.example.experience_platform.auth.dto.LoginResponseDto;
import com.example.experience_platform.auth.service.AuthService;
import com.example.experience_platform.user.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {


    private final AuthService authService;

    @PostMapping("/login")

    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto dto) {

        // 1) 로그인 수행
        UserVo user = authService.login(dto);

        // 2) 반환 DTO 변환
        LoginResponseDto response = LoginResponseDto.builder()
                .userId(user.getUserId())
                .loginId(user.getLoginId())
                .name(user.getName())
                .build();

        return ResponseEntity.ok(response);
    }
}
