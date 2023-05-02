package com.BEBuildweek2.auth.service;

import com.BEBuildweek2.auth.payload.LoginDto;
import com.BEBuildweek2.auth.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
