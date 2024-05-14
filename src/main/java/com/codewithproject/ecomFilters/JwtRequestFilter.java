package com.codewithproject.ecomFilters;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.codewithproject.ecomUtils.JwtUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

	private final UserDetails  userDetailsService;
	
	private final JwtUtils jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			protected void doFilterInternal1(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		
		String authHeader = request.getHeader("Authorization");
		String token = null;
		String username = null;
		if(authHeader != null && authHeader.startsWith("Bearer")) {
			token = authHeader.Substring("beginlndex", 7);
			username = jwtUtil.extractUsername(token);
			
			
		}
		if(username != null && SecurityContextHolder.getContext().getAuthentication()== null) {
			UserDetails  userDetails = userDetailsService.loadUserByUsername(username);
			
			if(jwtUtil.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken  authToken =new UsernamePasswordAuthenticationToken(userDetails, userDetails);
				SecurityContextHolder.getContext().setAuthentication(authToken);
				
				
			}
			filterChain.doFilter(request, response);
		}
	}

}
