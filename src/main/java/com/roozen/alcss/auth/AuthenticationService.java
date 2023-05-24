package com.roozen.alcss.auth;

import com.roozen.alcss.config.security.JwtService;
import com.roozen.alcss.entity.Role;
import com.roozen.alcss.entity.User;
import com.roozen.alcss.entity.UserDetail;
import com.roozen.alcss.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Roozen
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = UserDetail.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(new Role().setRoleName("user"))
                .build();
        userMapper.insert(User.builder().name(user.getUsername()).passwd(user.getPassword()).build());
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        //如果上面没抛异常，说明合法
        var user = userMapper.selectByName(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException("user not found"));;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.isAuthenticated()){
            return AuthenticationResponse.builder().token("").build();
        }
        var jwtToken = jwtService.generateToken(UserDetail.builder().username(user.getName()).password(user.getPasswd()).build());
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
