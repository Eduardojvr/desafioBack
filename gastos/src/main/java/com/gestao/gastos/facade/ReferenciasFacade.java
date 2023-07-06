package com.gestao.gastos.facade;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestao.gastos.dto.DespesasCategoria;
import com.gestao.gastos.dto.DespesasMes;
import com.gestao.gastos.dto.FonteDinheiro;
import com.gestao.gastos.dto.Referencia;
import com.gestao.gastos.service.ConsultarGastosService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

public class ReferenciasFacade {

    @Autowired
    private ConsultarGastosService gastos;

    public List<Referencia> dadosPeriodo() {
        List<Referencia> listaReferencias = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retornaReferencias(listaReferencias, objectMapper);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaReferencias;
    }

    private void retornaReferencias(List<Referencia> listaReferencias, ObjectMapper objectMapper)
            throws IOException, JsonProcessingException, JsonMappingException {
        HttpResponse responseGastosMes;
        responseGastosMes = gastos.integracaoConsulta(
                "SELECT distinct ano_movimentacao from \"d4d8a7f0-d4be-4397-b950-f0c991438111\"");
        String responseBody = responseGastosMes.body().toString();
        JsonNode jsonNode = objectMapper.readTree(responseBody);
        JsonNode recordsNode = jsonNode.path("result").path("records");

        for (JsonNode recordNode : recordsNode) {
            Referencia ref = objectMapper.treeToValue(recordNode, Referencia.class);
            listaReferencias.add(ref);
        }
    }

}
