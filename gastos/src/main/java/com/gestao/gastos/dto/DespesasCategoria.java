package com.gestao.gastos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DespesasCategoria {
    @JsonProperty("categoria_economica_nome")
    private String categoriaEconomicaNome;

    @JsonProperty("categoria_economica_codigo")
    private int categoriaEconomicaCodigo;

    @JsonProperty("sum")
    private float total;
}
