package com.example.experience_platform.auth.jwt;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    private static final String secretKey = "abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd";

    public final static long ACCESS_TOKEN_VALIDATION_SECOND = 1000L * 60 * 60 * 12;
    public static final String AUTHORIZATION_HEADER = "Authorization";

    public String createAccessToken(String memberId, String name) {

        Date now = new Date();
        Date expiration = new Date(now.getTime() + ACCESS_TOKEN_VALIDATION_SECOND);

        return Jwts.builder()
                .setSubject(memberId)
                .claim("name", name)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            System.out.println("잘못된 토큰 서명입니다.");
        } catch (ExpiredJwtException e) {
            System.out.println("만료된 토큰입니다.");
        } catch (IllegalArgumentException | MalformedJwtException e) {
            System.out.println("잘못된 토큰입니다.");
        }
        return false;
    }

    public String getId(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String getName(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .get("name").toString();
    }

    public String getAccessToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
