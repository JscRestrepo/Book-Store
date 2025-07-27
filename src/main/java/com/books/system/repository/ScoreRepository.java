package com.books.system.repository;

import com.books.system.model.entity.BookRating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ScoreRepository extends JpaRepository<BookRating, Long> {

    @Query(value = """
            SELECT
                book.book_id,
                book.title,
                AVG(rate.score) AS average_score
            FROM
                book book
            JOIN
                book_rating rate ON book.book_id = rate.book_id
            WHERE
                rate.created_at >= (CURRENT_DATE - INTERVAL 7 DAY)
            GROUP BY
                book.book_id, book.title
            ORDER BY
                average_score DESC;
            
            """,
            nativeQuery = true)
    Page<Object[]> findTopRatedBooksOfWeek(Pageable pageable);

}
