package com.webflux.server.convert.impl;

import com.webflux.server.convert.IConvertData;
import com.webflux.server.entity.BookEntity;
import com.webflux.server.model.BookModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

public class BookConvert implements IConvertData<BookModel, BookEntity> {

    private final ModelMapper modelMapper;

    public BookConvert() {
        modelMapper = new ModelMapper();
    }

    @Override
    public BookModel convertToDtoOrModel(BookEntity tObject) {
        BookModel bookModel = modelMapper.map(tObject, BookModel.class);
        return bookModel;
    }

    @Override
    public BookEntity convertToEntity(BookModel tObject) {
        BookEntity bookEntity = modelMapper.map(tObject, BookEntity.class);
        return bookEntity;
    }

    @Override
    public BookEntity apply(BookModel bookModel) {
        return null;
    }
}
