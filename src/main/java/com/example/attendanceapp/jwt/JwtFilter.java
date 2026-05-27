package com.example.attendanceapp.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Component;

import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    JwtService jwtService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest req,
            HttpServletResponse res,
            FilterChain chain)
            throws ServletException, IOException {

        String path = req.getRequestURI();

        // Allow auth APIs
        if (path.startsWith("/auth")) {

            chain.doFilter(req, res);
            return;
        }

        String header = req.getHeader("Authorization");

        // No token
        if (header == null ||
                !header.startsWith("Bearer ")) {

            chain.doFilter(req, res);
            return;
        }

        String token = header.substring(7);

        try {

            String email =
                    jwtService.extractEmail(token);

            String role =
                    jwtService.extractRole(token);

            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(

                            email,
                            null,

                            List.of(
                                    new SimpleGrantedAuthority(
                                            "ROLE_" + role
                                    )
                            )
                    );

            SecurityContextHolder
                    .getContext()
                    .setAuthentication(auth);

        } catch (Exception e) {

            res.setStatus(401);
            res.getWriter().write("Invalid Token");
            return;
        }

        chain.doFilter(req, res);
    }
}