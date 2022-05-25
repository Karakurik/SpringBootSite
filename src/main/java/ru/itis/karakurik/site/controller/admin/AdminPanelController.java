package ru.itis.karakurik.site.controller.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.karakurik.site.dto.books.BookDto;
import ru.itis.karakurik.site.service.books.interfaces.BookService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminPanelController {

    private final BookService bookService;

    @GetMapping("/new")
    public String showNewForm(ModelMap modelMap) {
        modelMap.addAttribute("addNew", true);
        return "admin/book_form";
    }

    @PostMapping("/insert")
    public String insertBook(ModelMap modelMap) {
        modelMap.addAttribute("addNew", true);
        return "admin/book_form";
    }

    @PostMapping("/delete")
    public String deleteBook(ModelMap modelMap) {
        modelMap.addAttribute("addNew", true);
        return "admin/book_form";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model, @RequestParam Long id) {
        BookDto bookDto = bookService.findById(id);
        model.addAttribute("update", true);
        model.addAttribute("book", bookDto);
        return "admin/book_form";
    }

    @PostMapping("/update")
    public String updateBook(ModelMap modelMap) {
        modelMap.addAttribute("addNew", true);
        return "admin/book_form";
    }

    @GetMapping("/")
    public String showBookList(ModelMap modelMap) {
        List<BookDto> books = bookService.getAllBooks();
        modelMap.put("listBook", books);
        return "admin/book_list";
    }

    @GetMapping("**")
    public String redirectToBooks() {
        return "redirect:/admin/";
    }
}
