package com.musicsite.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	private final byte[] secretKey;
	
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager, String secretKey) {
		super(authenticationManager);
		this.secretKey = secretKey.getBytes();
	}
	
	@Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) 
    		throws IOException, ServletException {
        String header = req.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }
	
	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            // parse the token.
        	try {
	            String user = JWT.require(Algorithm.HMAC512(secretKey))
	                    .build()
	                    .verify(token.replace("Bearer ", ""))
	                    .getSubject();
	
	            if (user != null) {
	                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
	            }
	            return null;
        	} catch (TokenExpiredException e) {
        		return null;
        	}
        }
        return null;
    }

}
