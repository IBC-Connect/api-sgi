package com.igrejaibc.sgi.controller;

import com.igrejaibc.sgi.http.Response;
import com.igrejaibc.sgi.model.membro.Usuario;
import com.igrejaibc.sgi.usecase.LoginUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/login")
public class LoginController {

    @Autowired
    private LoginUseCase loginUseCase;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid Usuario infoLogin){
        try {
            return this.loginUseCase.login(infoLogin);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message(e.getMessage()).build());
        }
    }

    @GetMapping("/{email}/dados")
    public ResponseEntity login(@PathVariable("email") String email){
        try {
            return this.loginUseCase.buscarDadosUsuario(email);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message(e.getMessage()).build());
        }
    }
}
