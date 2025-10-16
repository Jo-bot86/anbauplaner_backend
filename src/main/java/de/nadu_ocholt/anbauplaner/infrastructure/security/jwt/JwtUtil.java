package de.nadu_ocholt.anbauplaner.infrastructure.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.MacAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private final SecretKey key;
    private final MacAlgorithm algorithm = Jwts.SIG.HS256;
    private final long validityMs;

    public JwtUtil(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.validity-ms:3600000}") long validityMs
    ) {
        byte[] decodedKey = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(decodedKey);
        this.validityMs = validityMs;
    }

    public String generateToken(String subject) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityMs);

        return Jwts.builder()
                .subject(subject)
                .issuedAt(now)
                .expiration(expiry)
                .signWith(key, algorithm)
                .compact();
    }

    public boolean validate(String token) {
        try {
            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractSubject(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();

    }

}
