package com.example.experience_platform.user.service;

import com.example.experience_platform.user.mapper.UserMapper;
import com.example.experience_platform.user.vo.UserVo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }


    //회원 정보 저장 (회원가입)

    @Transactional
    public Long createUser(final UserVo userVo) {
        userVo.encodingPassword(passwordEncoder);
        return (long) userMapper.insert(userVo);
    }

    // 회원 수 카운팅 (ID 중복 체크)
    public int countMemberByLoginId(final String loginId) {
        return userMapper.countByLoginId(loginId);
    }

    // 회원정보조회
    public UserVo findByLoginId(String loginId) {
        return userMapper.findByLoginId(loginId);
    }

    // 회원정보수정
    public int update(UserVo userVo) {
        return userMapper.update(userVo);
    }


    // 회원탈퇴
    public int delete(Long loginId) {
        return userMapper.delete(loginId);
    }

}
