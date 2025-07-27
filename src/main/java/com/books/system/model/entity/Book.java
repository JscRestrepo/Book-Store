package com.books.system.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "book", indexes = {
        @Index(name = "idx_book_title", columnList = "title"),
        @Index(name = "idx_book_bookCode", columnList = "bookCode")
})
public class Book extends BaseAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String title;
    private String bookCode;
    private String author;
    private Double price;
}
