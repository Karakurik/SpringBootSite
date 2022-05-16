package ru.itis.karakurik.site.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.karakurik.site.dto.BookDto;
import ru.itis.karakurik.site.model.Role;
import ru.itis.karakurik.site.service.BookService;
import ru.itis.karakurik.site.service.GenreService;
import ru.itis.karakurik.site.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BooksController {
    private final BookService bookService;
    private final GenreService genreService;
    private final UserService userService;

    @GetMapping("/test")
    public String test() {
        return "books/books";
    }

    @GetMapping("/books")
    public String getBooks(
            Model model,
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam(name = "genre_id", required = false) Long genreId
    ) {
        setAdmin(model, userDetails);
        model.addAttribute("genreId", genreId);
        model.addAttribute("genreService", genreService);
        model.addAttribute("genres", genreService.getAllGenres());
        List<BookDto> books;
        if (genreId == null) {
            books = bookService.getAllBooks();
        } else {
            books = bookService.getBooksByGenre(genreId);
//            return "books/book_list";
        }
//        request.getSession().setAttribute("currentBookList", list);
        model.addAttribute("list", books);

        return "books/books";
    }

    public void setAdmin(Model model, UserDetails userDetails) {
        model.addAttribute(
                "isAdmin",
                userDetails.getAuthorities().contains(
                        new SimpleGrantedAuthority(
                                Role.ROLE_ADMIN.name()
                        )
                )
        );
    }
}
