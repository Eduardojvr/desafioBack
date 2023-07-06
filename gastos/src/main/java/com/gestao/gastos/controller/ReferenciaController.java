package com.gestao.gastos.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestao.gastos.facade.DadosPeriodoFacade;
import com.gestao.gastos.facade.ReferenciasFacade;

@RestController
@RequestMapping("/referencia")
@Component
public class ReferenciaController {

    @GetMapping(value = "/buscarReferencia", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity totalDespesaMes() {

        try {
            ReferenciasFacade integracao = new ReferenciasFacade();

            return ResponseEntity.ok(integracao.dadosPeriodo());
        } catch (Exception e) {
            return (ResponseEntity) ResponseEntity.internalServerError();
        }
    }

}