package com.dytak.crudapiserver.authentication;

import com.auth0.jwt.JWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;


public class AuthenticationFilter extends OncePerRequestFilter {

  private final CustomUserDetailService userDetailService;

  public AuthenticationFilter(CustomUserDetailService userDetailService) {
    this.userDetailService = userDetailService;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {

    if (JWTProvider.verifyAccessToken(request)) {
      String header = request.getHeader("Authorization");
      String token = header.substring(7);

      String username = JWT.decode(token).getSubject();

      UserDetails userDetails = userDetailService.loadUserByUsername(username);

      Authentication auth =
          new UsernamePasswordAuthenticationToken(
              userDetails,
              null,
              userDetails.getAuthorities());

      SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
      securityContext.setAuthentication(auth);
      SecurityContextHolder.setContext(securityContext);
    }

    filterChain.doFilter(request, response);
  }
}

