package com.example.experience_platform.user.service;

import com.example.experience_platform.user.mapper.UserMapper;
import com.example.experience_platform.user.vo.UserVo;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // 회원 가입
    public int createUser(UserVo userVo) {
        return userMapper.insert(userVo);
    }

    // 회원정보
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
