package com.webflux.server.api;

import com.webflux.server.model.BookModel;
import com.webflux.server.service.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/server/api/v1/book")
@AllArgsConstructor
public class BookApi {

    private final IBookService bookService;

    @GetMapping("")
    public List<BookModel> getListBook() {
        return bookService.findAll();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public BookModel createBook(@RequestBody BookModel bookModel) {
        return bookService.save(bookModel);
    }

}
