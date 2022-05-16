package ru.itis.karakurik.site.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.karakurik.site.dto.BookDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
@AllArgsConstructor
public class ShowImageController {

    @GetMapping("/showImage")
    public void showImage(HttpServletRequest request, HttpServletResponse response, @RequestParam("index") Integer index, ModelMap model) {
        response.setContentType("image/jpeg");
        try (OutputStream out = response.getOutputStream()) {
            List<BookDto> list = (List<BookDto>) model.getAttribute("book");
            BookDto book = list.get(index);
            if (book.getImage() != null) {
                response.setContentLength(book.getImage().length);
                out.write(book.getImage());
            }
        } catch (Exception ignored) {
        }
    }
}
