package com.webflux.client.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.webflux.client.domainmodel.BookDomainModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/book")
public class BookApi {

    WebClient webClient;

    public BookApi() {
        // TODO Auto-generated constructor stub
        this.webClient = WebClient
                .builder()
                .baseUrl("http://localhost:8081")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @GetMapping("")
    public Flux<BookDomainModel> getListBook() {
        return webClient
                .get()
                .uri("/server/api/v1/book")
                .retrieve()
                .bodyToFlux(BookDomainModel.class);
    }

    @PostMapping("")
    public Mono<BookDomainModel> save(@RequestBody BookDomainModel book) {
        return webClient
                .post()
                .uri("/server/api/v1/book")
                .bodyValue(book)
                .retrieve()
                .bodyToMono(BookDomainModel.class);
    }

}
