package com.webflux.server.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BookModel {

    private Long id;

    private String name;

    private String field;

    public BookModel(String name, String field) {
        this.name = name;
        this.field = field;
    }
}
