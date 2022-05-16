package ru.itis.karakurik.site.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.karakurik.site.exception.FileDownloadException;
import ru.itis.karakurik.site.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequiredArgsConstructor
public class ReadBookController {
    private final BookService bookService;

    @GetMapping("/readBook")
    public void readBook(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/pdf");
        try (OutputStream out = response.getOutputStream()) {
            long bookId = Long.parseLong(request.getParameter("id"));
            String contentFileName = bookService.getBookContentFileNameById(bookId);
            response.setHeader("Content-Disposition", "filename=\"" + contentFileName + "\"");
            bookService.downloadFile(contentFileName, out);
        } catch (IOException | FileDownloadException e) {
            response.setContentType("text/html");
            request.setAttribute("message", "Не удалось открыть файл");
//            request.getRequestDispatcher("/pages/readBook.jsp").forward(request, response);
        }
    }
}
