package com.gestao.gastos.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ConsultarGastosService {

    private static String apiUrl = "http://dados.recife.pe.gov.br/api/3/action/datastore_search_sql?";

    public static HttpResponse integracaoConsulta(String query) throws IOException {
        HttpClient client = HttpClient.newHttpClient();
        String encodedQuery = URLEncoder.encode(query, "UTF-8");
        String urlString = apiUrl + "sql=" + encodedQuery;
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(urlString))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

}
