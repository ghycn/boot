package com.org.hsd.util;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;

import java.util.Date;

public class JwtUtils {
    private static Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    public static final long EXPIRATION_TIME = 20 * 60 * 1000; // jwt 过期时间 20分钟
    public static final String AUTHORIZATION_HEADER_PREFIX = "Bearer ";
    public static final String SIGNING_KEY = "PrivateSecret";
    public static final String AUTHORIZATION = "Authorization";

    /**
     * remove 'Bearer ' string
     *
     * @param authorizationHeader
     * @return
     */
    public static String getRawToken(String authorizationHeader) {
        return authorizationHeader.substring(AUTHORIZATION_HEADER_PREFIX.length());
    }

    public static String getTokenHeader(String rawToken) {
        return AUTHORIZATION_HEADER_PREFIX + rawToken;
    }

    public static boolean validate(String authorizationHeader) {
        return StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith(AUTHORIZATION_HEADER_PREFIX);
    }

    public static String getAuthorizationHeaderPrefix() {
        return AUTHORIZATION_HEADER_PREFIX;
    }

    /**
     * 创建JWT
     * @param auth
     * @return
     */
    public static String createJWT(Authentication auth){
        String token = Jwts.builder()
                .setSubject(auth.getName())
                .setExpiration(new Date(System.currentTimeMillis() + JwtUtils.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, JwtUtils.SIGNING_KEY)
                .compact();
        return  JwtUtils.getTokenHeader(token);
    }


    /**
     * 解析JWT
     */
    public static String parseJWT(String token){
        try {
            String username = Jwts.parser()
                    .setSigningKey(JwtUtils.SIGNING_KEY)
                    .parseClaimsJws(token.replace(JwtUtils.getAuthorizationHeaderPrefix(), ""))
                    .getBody()
                    .getSubject();
            return username;
        } catch (ExpiredJwtException e) {
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>Token已过期！");
            e.printStackTrace();
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
        } catch (MalformedJwtException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return null;
    }
}
