package com.webflux.server.service;

import com.webflux.server.model.BookModel;

import java.util.List;

public interface IBookService {

    List<BookModel> findAll();

    BookModel save(BookModel bookModel);

}
