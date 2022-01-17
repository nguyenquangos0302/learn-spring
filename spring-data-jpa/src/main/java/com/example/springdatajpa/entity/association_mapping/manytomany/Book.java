package com.example.springdatajpa.entity.association_mapping.manytomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<BookPublisher> bookPublishers = new HashSet<>();

    public void addPublisher(BookPublisher bookPublisher) {
        if (bookPublisher != null) {
            if (this.bookPublishers == null) {
                this.bookPublishers = new HashSet<>();
            }
            bookPublisher.setBook(this);
            bookPublishers.add(bookPublisher);
        }
    }

}
