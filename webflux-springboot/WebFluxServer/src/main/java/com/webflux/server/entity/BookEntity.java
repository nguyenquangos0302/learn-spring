package com.webflux.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String showname;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, timezone = "Asia/Kolkata")
    private Date bookingtime;

    private int usercount;

    private double price;

    public BookEntity(String username, String showname, Date bookingtime, int usercount, double price) {
        this.username = username;
        this.showname = showname;
        this.bookingtime = bookingtime;
        this.usercount = usercount;
        this.price = price;
    }
}
