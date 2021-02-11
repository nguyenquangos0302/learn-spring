package com.webflux.server.repository;

import com.webflux.server.entity.BookEntity;
import com.webflux.server.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBookRepository extends JpaRepository<BookEntity, Long> {

}
