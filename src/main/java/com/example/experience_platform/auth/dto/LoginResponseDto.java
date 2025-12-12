package com.example.experience_platform.auth.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDto {
    private Long userId;
    private String loginId;
    private String name;
    private String token;   // JWT 나중에 붙임
}
