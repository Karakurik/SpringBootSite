package ru.itis.karakurik.site.controller.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.karakurik.site.aspects.logging.Logger;
import ru.itis.karakurik.site.dto.books.BookDto;
import ru.itis.karakurik.site.service.books.interfaces.BookService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminPanelController {

    private final BookService bookService;

    @Logger
    @GetMapping("/new")
    public String showNewForm(ModelMap modelMap) {
        modelMap.addAttribute("addNew", true);
        return "admin/book_form";
    }

    @Logger
    @PostMapping("/insert")
    public String insertBook(
            @Valid BookDto bookDto,
            ModelMap modelMap
    ) {
        modelMap.addAttribute("addNew", true);
        bookService.save(bookDto);
        return "redirect:/admin/books";
    }

    @Logger
    @PostMapping("/delete")
    public String deleteBook(
            ModelMap modelMap,
            @RequestParam("id") Long id
    ) {
        bookService.deleteBook(id);
        return "redirect:/admin/books";
    }

    @Logger
    @GetMapping("/edit")
    public String showEditForm(
            Model model,
            @RequestParam("id") Long id
    ) {
        BookDto bookDto = bookService.findById(id);
        model.addAttribute("update", true);
        model.addAttribute("book", bookDto);
        return "admin/book_form";
    }

    @Logger
    @PostMapping("/update")
    public String updateBook(
            @Valid BookDto bookDto,
            ModelMap modelMap
    ) {
        bookService.save(bookDto);
        return "redirect:/admin/books";
    }

    @Logger
    @GetMapping("/")
    public String showBookList(ModelMap modelMap) {
        List<BookDto> books = bookService.getAllBooks();
        modelMap.put("listBook", books);
        return "admin/book_list";
    }

    @Logger
    @GetMapping("**")
    public String redirectToBooks() {
        return "redirect:/admin/";
    }
}
