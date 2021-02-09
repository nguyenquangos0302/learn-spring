package com.webflux.server.repository;

import com.webflux.server.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<BookEntity, Long> {

}
