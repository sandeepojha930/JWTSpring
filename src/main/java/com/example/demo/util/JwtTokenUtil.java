package com.example.demo.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
@Service
public class JwtTokenUtil implements Serializable {
    private static final long sserialVersionUID = -2550185165626007488L;
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    @Value("${jwt.secret}")
    private String secret;

    public String getUsernameFormToken(String token){
        return getClaimFromToken(token, Claims::getSubject);
    }
    public  <T> T getClaimFromToken(String token, Function<Claims, T>  claimsResolver) {
     final Claims claims = getAllClaimsFromToken(token);
     return claimsResolver.apply(claims);
    }
    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }
public Boolean isTokenExpire(String token){
        Date date = getExpirationDateFromToken(token);
        return date.before(new Date());
}
public String generateToken(UserDetails userDetails){
    Map<String, Object> stringObjectMap = new HashMap<>();
    return doGenerateToken(stringObjectMap, userDetails.getUsername());
}
    private String doGenerateToken(Map<String, Object> stringObjectMap, String username) {
        return Jwts.builder().setClaims(stringObjectMap).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis())).
                setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY*1000)).signWith(SignatureAlgorithm.HS512,secret).compact();
    }
    public Boolean validateToken(String token, UserDetails userDetails){
 final String username = getUsernameFormToken(token);
 return (username.equals(userDetails.getUsername()) && !isTokenExpire(token));
    }

}
