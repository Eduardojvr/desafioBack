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
import com.gestao.gastos.service.ConsultarGastosService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

public class DadosPeriodoFacade {

    @Autowired
    private ConsultarGastosService gastos;

    public HashMap<Object, Object> dadosPeriodo(int ano) {
        List<DespesasMes> despesasMes = new ArrayList<>();
        List<DespesasCategoria> despesasCategoria = new ArrayList<>();
        List<FonteDinheiro> listaFonteDinheiro = new ArrayList<>();
        HashMap<Object, Object> retorno = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retornaListaDespesasMEs(ano, despesasMes, objectMapper);
            retornaListaDespesasCategoria(ano, despesasCategoria, objectMapper);
            retornaListaFonteDinheiro(ano, listaFonteDinheiro, objectMapper);

            retorno.put("DepesasMes", despesasMes);
            retorno.put("DespesasCategoria", despesasCategoria);
            retorno.put("FonteDinheiro", listaFonteDinheiro);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return retorno;
    }

    private void retornaListaDespesasMEs(int ano, List<DespesasMes> despesasCategoria, ObjectMapper objectMapper)
            throws IOException, JsonProcessingException, JsonMappingException {
        HttpResponse responseGastosMes;
        responseGastosMes = gastos.integracaoConsulta(
                "SELECT mes_movimentacao, ano_movimentacao , SUM(CAST(REPLACE(valor_pago, ',', '.') AS DECIMAL))  from \"d4d8a7f0-d4be-4397-b950-f0c991438111\" WHERE ano_movimentacao = "
                        + ano + " group by mes_movimentacao, ano_movimentacao");
        String responseBody = responseGastosMes.body().toString();
        JsonNode jsonNode = objectMapper.readTree(responseBody);
        JsonNode recordsNode = jsonNode.path("result").path("records");
        for (JsonNode recordNode : recordsNode) {
            DespesasMes despesa = objectMapper.treeToValue(recordNode, DespesasMes.class);
            despesasCategoria.add(despesa);
        }
    }

    private void retornaListaDespesasCategoria(int ano, List<DespesasCategoria> despesasCategoria,
            ObjectMapper objectMapper)
            throws IOException, JsonProcessingException, JsonMappingException {
        HttpResponse responseGastosCategoria;
        responseGastosCategoria = gastos.integracaoConsulta(
                "SELECT categoria_economica_nome, categoria_economica_codigo , SUM(CAST(REPLACE(valor_pago, ',', '.') AS DECIMAL))  from \"d4d8a7f0-d4be-4397-b950-f0c991438111\" WHERE ano_movimentacao = "
                        + ano + " group by categoria_economica_codigo, categoria_economica_nome");
        String responseBody = responseGastosCategoria.body().toString();
        JsonNode jsonNode = objectMapper.readTree(responseBody);
        JsonNode recordsNode = jsonNode.path("result").path("records");
        for (JsonNode recordNode : recordsNode) {
            DespesasCategoria despesa = objectMapper.treeToValue(recordNode, DespesasCategoria.class);
            despesasCategoria.add(despesa);
        }
    }

    private void retornaListaFonteDinheiro(int ano, List<FonteDinheiro> listaFonte,
            ObjectMapper objectMapper)
            throws IOException, JsonProcessingException, JsonMappingException {
        HttpResponse responseGastosCategoria;
        responseGastosCategoria = gastos.integracaoConsulta(
                "SELECT fonte_recurso_nome, fonte_recurso_codigo, SUM(CAST(REPLACE(valor_empenhado, ',', '.') AS DECIMAL))  from \"d4d8a7f0-d4be-4397-b950-f0c991438111\" WHERE ano_movimentacao = "
                        + ano + " group by fonte_recurso_codigo, fonte_recurso_nome");
        String responseBody = responseGastosCategoria.body().toString();
        JsonNode jsonNode = objectMapper.readTree(responseBody);
        JsonNode recordsNode = jsonNode.path("result").path("records");
        for (JsonNode recordNode : recordsNode) {
            FonteDinheiro despesa = objectMapper.treeToValue(recordNode, FonteDinheiro.class);
            listaFonte.add(despesa);
        }
    }

}
