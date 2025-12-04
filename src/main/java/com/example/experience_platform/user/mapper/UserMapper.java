package com.example.experience_platform.user.mapper;

import com.example.experience_platform.user.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {

    // 회원가입
    int insert(UserVo userVo);

    // 회원정보
    UserVo findByLoginId(String userId);

    // 회원정보 수정
    int update(UserVo userVo);

    // 회원탈퇴
    int delete(Long userid);
}
