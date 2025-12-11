package com.example.experience_platform.user.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    private Long userId; // 회원 번호(PK)
    private String loginId; // 로그인 ID
    private String password; // 비밀번호
    private String name; // 이름
    private String gender; // 성별
    private String email; // 이메일
    private String role; // 역할(권한)

    //encodingPassword( )는 비밀번호를 암호화
    public void encodingPassword(PasswordEncoder passwordEncoder) {
        if (StringUtils.isEmpty(password)) {
            return;
        }
        password = passwordEncoder.encode(password);
    }
}
