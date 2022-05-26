package ru.itis.karakurik.site.controller.books;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.karakurik.site.service.books.interfaces.BookService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

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
            Files.copy(Paths.get("src/main/resources/static/files/" + contentFileName), out);
        } catch (IOException e) {
            response.setContentType("text/html");
            request.setAttribute("message", "Не удалось открыть файл");
        }
    }
}
