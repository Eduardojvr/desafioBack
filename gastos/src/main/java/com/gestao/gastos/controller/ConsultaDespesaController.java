package com.gestao.gastos.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestao.gastos.facade.DadosPeriodoFacade;

@RestController
@RequestMapping("/despesas")
@Component
public class ConsultaDespesaController {

    @GetMapping(value = "/buscarDadosReferencia", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity totalDespesaMes(@RequestParam("ano") int ano) {

        try {
            DadosPeriodoFacade integracao = new DadosPeriodoFacade();

            return ResponseEntity.ok(integracao.dadosPeriodo(ano));
        } catch (Exception e) {
            return (ResponseEntity) ResponseEntity.internalServerError();
        }
    }

}
