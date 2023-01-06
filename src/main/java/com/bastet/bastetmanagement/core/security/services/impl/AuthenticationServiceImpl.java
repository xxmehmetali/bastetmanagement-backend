package com.bastet.bastetmanagement.core.security.services.impl;

import com.bastet.bastetmanagement.core.security.jwt.JwtUtils;
import com.bastet.bastetmanagement.core.security.payload.response.JwtResponse;
import com.bastet.bastetmanagement.core.security.payload.response.MessageResponse;
import com.bastet.bastetmanagement.core.security.services.AuthenticationService;
import com.bastet.bastetmanagement.core.security.services.CacheService;
import com.bastet.bastetmanagement.daos.UserDao;
import com.bastet.bastetmanagement.models.RoleEnum;
import com.bastet.bastetmanagement.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserDao userDao;

    @Autowired
    com.bastet.bastetmanagement.daos.RoleDao RoleDao;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    CacheService cacheService;

    public JwtResponse authenticateUser(String username, String password) {
        log.info("Authentication request start processing. Authenticate with username and password.");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtUtils.generateJwtToken(authentication);

        log.info("Populating user details.");
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        cacheService.saveLoggedInUser(jwtToken, userDao.findByUsername(username).get());

        log.info("Authentication success. Generating response.");
        return new JwtResponse(jwtToken,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail());
    }

    public MessageResponse registerUser(String username, String password, String email) {
        log.info("Registration request start processing. Checking db user existence.");
        if (userDao.existsByUsername(username)) {
            log.info("User already available in db.");
            return null;
        }

        // Create a new user
        log.info("Creating new user.");
        User user = new User(
                username,
                email,
                encoder.encode(password)
        );
//        Set<Role> roles = new HashSet<>();
//
//        if (inputRoles == null) {
//            Role role = RoleDao.findByName(RoleEnum.ROLE_USER)
//                    .orElseThrow(() -> new RuntimeException("Error: Roles not found in request / db."));
//            roles.add(role);
//        } else {
//            inputRoles.forEach(inputRole -> {
//                Role role = RoleDao.findByName(inputRole)
//                        .orElseThrow(() -> new RuntimeException("Error: Role not found in db."));
//                roles.add(role);
//            });
//        }
//        log.info("Setting roles.");
//        user.setRoles(roles);
        user.setRoles(new HashSet<>(Arrays.asList(RoleDao.findByName(RoleEnum.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Role could not find!")))));
        log.info("Saving new user to db.");
        userDao.save(user);

        return new MessageResponse("User registered successfully!");
    }
}
