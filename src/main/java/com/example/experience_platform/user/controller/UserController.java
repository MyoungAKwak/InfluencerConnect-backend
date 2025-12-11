package com.example.experience_platform.user.controller;

import com.example.experience_platform.user.service.UserService;
import com.example.experience_platform.user.vo.UserVo;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user") // 프록시와 맞춤
public class UserController {
    private final UserService userService;
    
    public UserController(UserService userService){
        this.userService = userService;
    }

    // 회원가입
    @PostMapping
    @ResponseBody
    public Long saveUser(@RequestBody final UserVo userVo) {
        return userService.createUser(userVo);
    }

    
    // 회원정보 조회
    //단일조회
    @GetMapping("/{loginId}")
    public UserVo getUser(@PathVariable String loginId) {
        return userService.findByLoginId(loginId);
    }

    // 회원정보 수정
    @PutMapping("/{loginId}")
    public int updateUser(@PathVariable String loginId, @RequestBody UserVo userVo) {
        userVo.setLoginId(loginId);
        return userService.update(userVo);
    }

    // 회원 수 카운팅 (ID 중복 체크)
    @GetMapping("/member-count")
    @ResponseBody
    public int countMemberByLoginId(@RequestParam final String loginId) {
        return userService.countMemberByLoginId(loginId);
    }

    // 회원탈퇴
}
