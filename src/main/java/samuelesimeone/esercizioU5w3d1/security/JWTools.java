package samuelesimeone.esercizioU5w3d1.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import samuelesimeone.esercizioU5w3d1.entities.Employee;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JWTools {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(Employee employee){
        return Jwts.builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .subject(String.valueOf(employee.getId()))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)))
                .compact();
    }
}
