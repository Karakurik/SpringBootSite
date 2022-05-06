package ru.itis.karakurik.site.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.karakurik.site.dto.BookDto;
import ru.itis.karakurik.site.exception.BookNotFoundException;
import ru.itis.karakurik.site.exception.FileDownloadException;
import ru.itis.karakurik.site.exception.FileUploadException;
import ru.itis.karakurik.site.repository.BookRepository;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
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
        return null;
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
}
