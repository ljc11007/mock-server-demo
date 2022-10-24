package com.example.mockserverdemo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import static java.util.TimeZone.*;

class MockServerDemoApplicationTests {

    @Test
    void generatorAuth() {
        Algorithm algorithm = Algorithm.HMAC256("ljc11007");
        String signingKeyId = algorithm.getSigningKeyId();
        System.out.println(signingKeyId);
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.add(Calendar.DAY_OF_MONTH, 28);
        Map header = new HashMap();
        header.put("alg","HS256");
        header.put("typ","JYT");
        //header、payload、expireDate、signature
        String sign = JWT.create().withHeader(header).withClaim("userId", 21).withExpiresAt(calendar.getTime()).sign(algorithm);
        System.out.println(sign);
    }

    @Test
    void verifyAuth(){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("ljc11007")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NjkwNDE5NTgsInVzZXJJZCI6MjF9.yVXr03dSM_Keqw9NcoqtFEzh9EzW42VHZHPx4ZvVXnI");
        String header = decodedJWT.getHeader();
        Claim userId = decodedJWT.getClaim("userId");

        System.out.println(userId);

    }

}
