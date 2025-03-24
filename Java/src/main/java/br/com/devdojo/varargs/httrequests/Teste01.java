package br.com.devdojo.varargs.httrequests;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Teste01 {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest build = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:3000/person"))
                .GET()
                .build();

        HttpResponse<String> send = HttpClient.newHttpClient()
                .send(build, HttpResponse.BodyHandlers.ofString());

        System.out.println(send.body());


        HttpRequest.newBuilder();
    }
}
