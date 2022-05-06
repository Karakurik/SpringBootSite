package ru.itis.karakurik.site.service;

import ru.itis.karakurik.site.dto.BookDto;
import ru.itis.karakurik.site.exception.FileDownloadException;
import ru.itis.karakurik.site.exception.FileUploadException;

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
}
