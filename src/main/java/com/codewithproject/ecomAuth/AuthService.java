package com.codewithproject.ecomAuth;

import com.codewithproject.ecomDto.SignupRequest;
import com.codewithproject.ecomDto.UserDto;

import jakarta.security.auth.message.AuthException;

public interface AuthService {
	
	UserDto createUser(SignupRequest singupReqest) throws AuthException;
	Boolean hasUserWithEmail(String email);

}
