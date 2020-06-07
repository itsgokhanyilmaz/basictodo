package com.gokhany.basictodo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@Service
public class JwtUtil {

    private static final String SECRET_TOKEN = "g4M4sAKXWkR1sx";

    public String createToken(ObjectId userId){
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_TOKEN);
            return JWT.create()
                    .withClaim("userId", userId.toString())
                    .withClaim("createdAt", new Date())
                    .sign(algorithm);
        }
        catch (UnsupportedEncodingException exception){}
        catch (JWTCreationException exception){}

        return null;
    }

    public String getUserIdFromToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_TOKEN);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);

            return jwt.getClaim("userId").asString();

        } catch (UnsupportedEncodingException exception) {
            exception.printStackTrace();

            return null;
        } catch (JWTVerificationException exception) {
            return null;
        }

    }

    public boolean isTokenValid(String token) {
        String userId = this.getUserIdFromToken(token);
        return userId != null;
    }

    public static String getObjectIdFromRequest(HttpServletRequest httpServletRequest){

        return (String) httpServletRequest.getAttribute("UserId");
    }

}
