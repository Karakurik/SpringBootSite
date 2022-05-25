package ru.itis.karakurik.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.karakurik.site.model.books.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM book " +
                    "WHERE genre_id = :id"
    )
    List<Book> findAllByGenreId(Long id);

    @Modifying
    @Transactional
    @Query(
            nativeQuery = true,
            value = "UPDATE book " +
                    "SET name = :name," +
                    "page_count = :page_count," +
                    "isbn = :isbn," +
                    "genre_id = :genre_id," +
                    "author_id = :author_id," +
                    "publish_date = :publish_date," +
                    "publisher_id = :publisher_id " +
                    "WHERE id =:book_id"
    )
    Book updateBook(
            @Param("book_id") Long id,
            @Param("name") String name,
            @Param("page_count") int pageCount,
            @Param("isbn") String isbn,
            @Param("genre_id") Long genreId,
            @Param("author_id") Long authorId,
            @Param("publish_date") int publishDate,
            @Param("publisher_id") Long publisherId
    );

    @Query(
            nativeQuery = true,
            value = "SELECT content_file_name " +
                    "FROM book " +
                    "WHERE id = :book_id"
    )
    String getBookContentFileNameById(@Param("book_id") Long bookId);

}
