package io.infi.devtogetherapi.services.mappers;

import io.infi.devtogetherapi.models.User;
import io.infi.devtogetherapi.services.JwtService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.security.Key;
import io.jsonwebtoken.io.Decoders;

@Service
public class HmacJwtService implements JwtService {
    private final Key key;

    public HmacJwtService(@Value("${security.jwt.secret}") String secret) {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String getSubject(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }

    @Override
    public String getToken(User user) {
        return Jwts.builder()
            .setSubject(user.getUsername())
            .signWith(key)
            .compact();
    }
}
