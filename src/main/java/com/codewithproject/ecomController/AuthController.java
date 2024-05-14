package com.codewithproject.ecomController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewithproject.ecomAuth.AuthService;
import com.codewithproject.ecomDto.AuthenticationRequest;
import com.codewithproject.ecomDto.SignupRequest;
import com.codewithproject.ecomDto.UserDto;
import com.codewithproject.ecomRepository.UserRepository;

import com.codewithproject.ecomUtils.JwtUtils;

import jakarta.security.auth.message.AuthException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {
    
    private  AuthenticationManager authenticationManager;
    private  UserDetailsService userDetailsService;
    private  UserRepository userRepository;
    private  JwtUtils jwtUtil;
    private  AuthService authService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest,
                                                        HttpServletResponse response) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
         String jwt = jwtUtil.generateToken(userDetails);

        return userRepository.findFirstByEmail(userDetails.getUsername())
                .map(user -> ResponseEntity.ok()
                        .header("Authorization", "Bearer " + jwt)
                        .body(new UserDto(user.getId(), user.getRoles()))
                .orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest) throws AuthException {
        if (authService.hasUserWithEmail(signupRequest.getEmail())) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("User already exists");
        }
        UserDto userDto = authService.createUser(signupRequest);
        return ResponseEntity.ok(userDto);
    }
}
