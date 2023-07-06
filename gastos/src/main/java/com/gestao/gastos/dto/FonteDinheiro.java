package com.gestao.gastos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FonteDinheiro {
    @JsonProperty("fonte_recurso_nome")
    private String fonteRecursoNome;

    @JsonProperty("fonte_recurso_codigo")
    private int fonteRecursoCodigo;

    @JsonProperty("sum")
    private float total;

}
