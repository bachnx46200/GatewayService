package com.example.GatewayService.api;


import com.example.GatewayService.entity.Account;
import com.example.GatewayService.entity.Token;
import com.example.GatewayService.security.JwtUtil;
import com.example.GatewayService.security.UserPrincipal;
import com.example.GatewayService.service.TokenService;
import com.example.GatewayService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({""})
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public Account register(@RequestBody Account account) {
        account.setPass(new BCryptPasswordEncoder().encode(account.getPass()));
        return userService.createUser(account);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Account account) {
        UserPrincipal userPrincipal = userService.findByUsername(account.getEmail());
        if (null == account || !new BCryptPasswordEncoder().matches(account.getPass(), userPrincipal.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("tài khoản hoặc mật khẩu không chính xác");
        }

        Token token = new Token();
        token.setToken(jwtUtil.generateToken(userPrincipal));
        token.setTokenExpDate(jwtUtil.generateExpirationDate());
        token.setRoles(userPrincipal.getRoles());
        token.setEmail(userPrincipal.getUsername());
//        if(userPrincipal.getMagiaovien() !=null){
//            token.setManguoidung(userPrincipal.getMagiaovien());
//        }else if (userPrincipal.getMahocsinh()!=null){
//            token.setManguoidung(userPrincipal.getMahocsinh());
//        }
        tokenService.createToken(token);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/welcom")
    public ResponseEntity welcom() {



        return ResponseEntity.ok("hello");
    }


    @GetMapping("/checkdaotao")
    @PreAuthorize("hasAnyAuthority('DT')")
    public ResponseEntity daotao() {
        return ResponseEntity.ok("daotao");
    }
    @GetMapping("/checkhocsinh")
    @PreAuthorize("hasAnyAuthority('HS')")
    public ResponseEntity hocsinh() {
        return ResponseEntity.ok("hocsinh");
    }


}
