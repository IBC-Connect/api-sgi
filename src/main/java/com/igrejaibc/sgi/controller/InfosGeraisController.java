package com.igrejaibc.sgi.controller;

import com.igrejaibc.sgi.http.Response;
import com.igrejaibc.sgi.usecase.InfoGeraisUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/informacoes")
public class InfosGeraisController {

    @Autowired
    private InfoGeraisUseCase infoGeraisUseCase;

    @GetMapping
    public ResponseEntity infoGerais() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/aniversantes-mes")
    public ResponseEntity aniversariantesMes() {
        try {
            return this.infoGeraisUseCase.aniversariantesMes();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message(e.getMessage()).build());
        }
    }

}
