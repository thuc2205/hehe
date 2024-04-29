    package com.shopcuatao.bangiay.component;

    import com.shopcuatao.bangiay.model.User;
    import io.jsonwebtoken.Claims;
    import io.jsonwebtoken.Jwts;
    import io.jsonwebtoken.SignatureAlgorithm;
    import io.jsonwebtoken.io.Decoders;
    import io.jsonwebtoken.security.Keys;
    import lombok.RequiredArgsConstructor;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.stereotype.Component;

    import java.security.InvalidParameterException;
    import java.security.Key;
    import java.security.SecureRandom;
    import java.util.Date;
    import java.util.HashMap;
    import java.util.Map;
    import java.util.Objects;
    import java.util.function.Function;

    @Component
    @RequiredArgsConstructor
    public class JwtTokenUtil {

        @Value("${jwt.secretkey}")
        private  String SECRET_KEY;
        private static final long EXPIRATION_TIME = 86400000; // 1 day in milliseconds

        public String generateToken(User user) {
            Date now = new Date();
            Date expiration = new Date(now.getTime() + EXPIRATION_TIME);
            try {
                Map<String, String> claim = new HashMap<>();
                claim.put("phoneNumber",user.getPhoneNumber());
                String token = Jwts.builder()
                        .setClaims(claim)
                        .setSubject(user.getPhoneNumber())
                        .setIssuedAt(now)
                        .setExpiration(expiration)
                        .signWith(getSignInKey(),SignatureAlgorithm.HS256)
                        .compact();
                return token;
            }catch (Exception e){
              throw new InvalidParameterException(e.getMessage());
            }

        }
        private Key getSignInKey(){
            byte[] bytes = generateSecureKey(32);
            return Keys.hmacShaKeyFor(bytes);
        }
        private byte[] generateSecureKey(int keySizeInBytes) {
            SecureRandom random = new SecureRandom(); // Initialize a SecureRandom object
            byte[] key = new byte[keySizeInBytes]; // Create a byte array of the desired key size
            random.nextBytes(key); // Generate random bytes into the key array
            return key;
        }
        public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
            final Claims claims = extractAllClaims(token);
            return claimsResolver.apply(claims);
        }

        // Hàm trích xuất số điện thoại từ token
        public String extractPhoneNumber(String token) {
            return extractClaim(token, Claims::getSubject);
        }

        // Hàm trích xuất tất cả các claim từ token
        private Claims extractAllClaims(String token) {
            return Jwts.parser().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
        }

    }
