package com.webflux.server.service.impl;

import com.webflux.server.convert.IConvertData;
import com.webflux.server.convert.impl.BookConvert;
import com.webflux.server.entity.BookEntity;
import com.webflux.server.model.BookModel;
import com.webflux.server.repository.IBookRepository;
import com.webflux.server.service.IBookService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService implements IBookService {

    private final IBookRepository bookRepository;

    @Override
    public List<BookModel> findAll() {
        List<BookModel> lists = bookRepository.findAll()
                                .stream()
                                //.map(this::convertToDtoOrModel)
                                .map(book -> new BookConvert().convertToDtoOrModel(book))
                                .collect(Collectors.toList());
        return lists;
    }

    @Override
    public BookModel save(BookModel bookModel) {
        BookEntity bookEntity = new BookConvert().convertToEntity(bookModel);
        BookEntity bookEntity1 = bookRepository.save(bookEntity);
        return new BookConvert().convertToDtoOrModel(bookEntity1);
    }

}
