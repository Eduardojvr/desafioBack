package com.gestao.gastos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DespesasMes {
    @JsonProperty("mes_movimentacao")
    private int mesMovimentacao;

    @JsonProperty("ano_movimentacao")
    private int anoMovimentacao;

    @JsonProperty("sum")
    private double total;
}
