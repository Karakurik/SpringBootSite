package ru.itis.karakurik.site.service.books.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.karakurik.site.dto.books.BookDto;
import ru.itis.karakurik.site.exception.books.BookNotFoundException;
import ru.itis.karakurik.site.exception.books.FileDownloadException;
import ru.itis.karakurik.site.exception.books.FileUploadException;
import ru.itis.karakurik.site.model.books.Book;
import ru.itis.karakurik.site.repository.jpa.BookRepository;
import ru.itis.karakurik.site.service.books.interfaces.BookService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(BookDto::from).collect(Collectors.toList());
    }

    @Override
    public List<BookDto> getBooksByGenre(long id) {
        return bookRepository.findAllByGenreId(id).stream()
                .map(BookDto::from).collect(Collectors.toList());
    }

    @Override
    public String getBookContentFileNameById(long id) {
        return bookRepository.getBookContentFileNameById(id);
    }

    @Override
    public BookDto selectBook(int id) {
        return null;
    }

    @Override
    public void downloadFile(String fileName, OutputStream responseOutputStream) throws IOException, FileDownloadException {

    }

    @Override
    public void uploadFile(String submittedFileName, InputStream inputStream) throws IOException, FileUploadException {

    }

    @Override
    public BookDto findById(Long id) {
        return BookDto.from(bookRepository.findById(id).orElseThrow(BookNotFoundException::new));
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void update(
            Long id,
            String bookName,
            int pageCount,
            String isbn,
            Long genreId,
            Long authorId,
            int publishDate,
            Long publisherId) {
        bookRepository.updateBook(
                id,
                bookName,
                pageCount,
                isbn,
                genreId,
                authorId,
                publishDate,
                publisherId
        );
    }

    @Override
    public void save(BookDto bookDto) {
        bookRepository.save(
                Book.builder()
                        .isbn(bookDto.getIsbn())
                        .build()
        );
    }
}
