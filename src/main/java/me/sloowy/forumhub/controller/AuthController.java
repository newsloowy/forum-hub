package me.sloowy.forumhub.controller;

import jakarta.validation.Valid;
import me.sloowy.forumhub.infra.auth.AuthDTO;
import me.sloowy.forumhub.domain.user.User;
import me.sloowy.forumhub.infra.TokenJwtDTO;
import me.sloowy.forumhub.infra.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthDTO authDTO) {
        var token = new UsernamePasswordAuthenticationToken(authDTO.email(), authDTO.password());
        var auth = authManager.authenticate(token);
        var tokenJwt = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new TokenJwtDTO(tokenJwt));
    }
}
