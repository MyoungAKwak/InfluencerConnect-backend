package com.example.experience_platform.auth.service;

import com.example.experience_platform.auth.dto.LoginRequestDto;
import com.example.experience_platform.auth.dto.LoginResponseDto;
import com.example.experience_platform.user.mapper.UserMapper;
import com.example.experience_platform.user.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserVo login(LoginRequestDto dto) {
        String loginId = dto.getLoginId();
        String rawPassword = dto.getPassword();

        UserVo user = userMapper.findByLoginId(loginId);

        if (user == null) {
            throw new UsernameNotFoundException("아이디가 존재하지 않습니다.");
        }

        // rawPassword vs user.getPassword()
        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }
          return user;
    }


}