package com.saca.backEnd;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class AuthorizationFilter extends BasicAuthenticationFilter {

    public AuthorizationFilter(AuthenticationManager authentication) {
        super(authentication);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
                String header = request.getHeader("Authorization");
                if(header == null || !header.startsWith("Bearer")){
                    chain.doFilter(request, response);
                    return;
                }
                UsernamePasswordAuthenticationToken auth = getAuthentication(request);
                SecurityContextHolder.getContext().setAuthentication(auth);
                chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token != null){
            Claims body = Jwts.parser()
                .setSigningKey("casa")
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody();

            String user = body.getSubject();

            if(user != null){
                final Collection<SimpleGrantedAuthority> auths = 
                    Arrays.stream(body.get("Authorities").toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

                return new UsernamePasswordAuthenticationToken(user, null, auths);
            }
            return null;
        }
        return null;
    }

}
