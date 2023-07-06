package com.gestao.gastos.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.client.RestTemplate;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.http.HttpHeaders;
import java.util.HashMap;

import com.gestao.gastos.dto.DespesasCategoria;
import com.gestao.gastos.dto.DespesasMes;
import com.gestao.gastos.dto.FonteDinheiro;
import com.gestao.gastos.dto.Referencia;
import com.gestao.gastos.facade.DadosPeriodoFacade;
import com.gestao.gastos.service.ConsultarGastosService;

import io.jsonwebtoken.lang.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class ConsultaDespesaControllerTests {

	private ConsultaDespesaController seuControlador;
	private Index indexController;
	private DadosPeriodoFacade mockFacade;

	@Before
	public void setup() {
		mockFacade = mock(DadosPeriodoFacade.class);
		seuControlador = new ConsultaDespesaController();
		indexController = new Index();
	}

	@Test
	public void testTotalDespesaMes() {
		int ano = 2022; // Ano de exemplo
		HashMap<Object, Object> resultadoEsperado = new HashMap<>();
		when(mockFacade.dadosPeriodo(ano)).thenReturn(any());
		ResponseEntity responseEntity = seuControlador.totalDespesaMes(ano);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void testHealthApp() {
		ResponseEntity expectedResponse = ResponseEntity.ok("API NO AR!");
		ResponseEntity actualResponse = indexController.index();
		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());

	}

	@Test
	public void testDtoDespesasCategoria() {
		DespesasCategoria despesasCategoria = new DespesasCategoria();

		despesasCategoria.setCategoriaEconomicaNome("Categoria 1");
		despesasCategoria.setCategoriaEconomicaCodigo(123);
		despesasCategoria.setTotal(100.0f);

		assertEquals("Categoria 1", despesasCategoria.getCategoriaEconomicaNome());
		assertEquals(123, despesasCategoria.getCategoriaEconomicaCodigo());
		assertEquals(100.0f, despesasCategoria.getTotal(), 0.01);

		despesasCategoria.setCategoriaEconomicaNome("Categoria 2");
		despesasCategoria.setCategoriaEconomicaCodigo(456);
		despesasCategoria.setTotal(200.0f);

		assertEquals("Categoria 2", despesasCategoria.getCategoriaEconomicaNome());
		assertEquals(456, despesasCategoria.getCategoriaEconomicaCodigo());
		assertEquals(200.0f, despesasCategoria.getTotal(), 0.01);
	}

	@Test
	public void testDtoDespesasMes() {
		DespesasMes despesasMes = new DespesasMes();

		despesasMes.setMesMovimentacao(6);
		despesasMes.setAnoMovimentacao(2022);
		despesasMes.setTotal(1000.0);

		assertEquals(6, despesasMes.getMesMovimentacao());
		assertEquals(2022, despesasMes.getAnoMovimentacao());
		assertEquals(1000.0, despesasMes.getTotal(), 0.01);

		despesasMes.setMesMovimentacao(12);
		despesasMes.setAnoMovimentacao(2023);
		despesasMes.setTotal(2000.0);

		assertEquals(12, despesasMes.getMesMovimentacao());
		assertEquals(2023, despesasMes.getAnoMovimentacao());
		assertEquals(2000.0, despesasMes.getTotal(), 0.01);
	}

}
