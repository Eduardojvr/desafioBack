package com.gestao.gastos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class Index {

    @RequestMapping(value = "/")
    public ResponseEntity index() {
        System.out.println("API NO AR!");
        return ResponseEntity.ok("API NO AR!");
    }

}
