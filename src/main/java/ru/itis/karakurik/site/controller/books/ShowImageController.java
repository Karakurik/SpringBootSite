package ru.itis.karakurik.site.controller.books;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.karakurik.site.dto.books.BookDto;
import ru.itis.karakurik.site.service.books.interfaces.BookService;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

@Controller
@RequiredArgsConstructor
public class ShowImageController {

    private final BookService bookService;

    @GetMapping("/showImage")
    public void showImage(HttpServletResponse response, @RequestParam("id") Long id) {
        response.setContentType("image/jpeg");
        try (OutputStream out = response.getOutputStream()) {
            BookDto book = bookService.findById(id);
            if (book.getImage() != null) {
                response.setContentLength(book.getImage().length);
                out.write(book.getImage());
            }
        } catch (Exception ignored) {
        }
    }
}
