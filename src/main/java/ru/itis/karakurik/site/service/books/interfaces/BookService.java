package ru.itis.karakurik.site.service.books.interfaces;

import ru.itis.karakurik.site.dto.books.BookDto;
import ru.itis.karakurik.site.exception.books.FileDownloadException;
import ru.itis.karakurik.site.exception.books.FileUploadException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public interface BookService {
    List<BookDto> getAllBooks();

    List<BookDto> getBooksByGenre(long id);

    String getBookContentFileNameById(long id);

    BookDto selectBook(int id);

    void downloadFile(String fileName, OutputStream responseOutputStream) throws IOException, FileDownloadException;

    void uploadFile(String submittedFileName, InputStream inputStream) throws IOException, FileUploadException;

    BookDto findById(Long id);

    void deleteBook(Long id);

    void update(
            Long id,
            String bookName,
            int pageCount,
            String isbn,
            Long genreId,
            Long authorId,
            int publishDate,
            Long publisherId);
}
