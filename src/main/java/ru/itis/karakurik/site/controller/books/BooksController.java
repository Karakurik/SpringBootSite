package ru.itis.karakurik.site.controller.books;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.karakurik.site.aspects.logging.Logger;
import ru.itis.karakurik.site.dto.books.BookDto;
import ru.itis.karakurik.site.dto.books.SearchForm;
import ru.itis.karakurik.site.model.user.Role;
import ru.itis.karakurik.site.repository.jpa.BookRepository;
import ru.itis.karakurik.site.service.books.interfaces.BookService;
import ru.itis.karakurik.site.service.books.interfaces.GenreService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class BooksController {
    private final BookService bookService;
    private final GenreService genreService;
    private final BookRepository bookRepository;

    @Logger
    @GetMapping("/books/genre")
    public String getAllBooks(
            ModelMap map,
            @RequestParam(name = "genre_id", required = false) Long genreId
    ) {
        map.addAttribute("genreId", genreId);

        List<BookDto> books;
        if (genreId == null) {
            books = bookService.getAllBooks();
        } else {
            books = bookService.getBooksByGenre(genreId);
        }

        map.put("isBooksExists", !books.isEmpty());

        if (books.isEmpty()) {
            books = bookRepository.getAllBooksWhichInFavourite().stream().map(BookDto::from).collect(Collectors.toList());
        }

        map.put("list", books);
        return "books/book_list";
    }

    @Logger
    @GetMapping({"/books", "/"})
    public String getBooks(
            ModelMap model,
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam(name = "genre_id", required = false) Long genreId
    ) {
        if (userDetails != null) {
            setAdmin(model, userDetails);
        }
        model.addAttribute("genreId", genreId);
        model.addAttribute("genreService", genreService);
        model.addAttribute("genres", genreService.getGenreList());

        // TODO: 25.05.2022 непонятно почему, но js поломался, пока с повтором кода будет
        List<BookDto> books;
        if (genreId == null) {
            books = bookService.getAllBooks();
        } else {
            books = bookService.getBooksByGenre(genreId);
        }

        model.put("isBooksExists", !books.isEmpty());

        if (books.isEmpty()) {
            books = bookRepository.getAllBooksWhichInFavourite().stream().map(BookDto::from).collect(Collectors.toList());
        }

        model.addAttribute("list", books);
        return "books/books";
    }

    @Logger
    @PostMapping("/books")
    public String getBooksSearch(
            ModelMap model,
            @AuthenticationPrincipal UserDetails userDetails,
            SearchForm searchForm
    ) {
        if (userDetails != null) {
            setAdmin(model, userDetails);
        }
        model.addAttribute("genres", genreService.getGenreList());
        List<BookDto> books = bookService.getAllBooks();

        String searchString = searchForm.getSearchString();
        String searchOption = searchForm.getSearchOption();
        switch (searchOption) {
            case "Название":
                books = books.stream()
                        .filter(o -> o.getName().toLowerCase().contains(searchString.toLowerCase()))
                        .collect(Collectors.toList());
                break;
            case "Автор":
                books = books.stream()
                        .filter(o -> o.getAuthor().toLowerCase().contains(searchString.toLowerCase()))
                        .collect(Collectors.toList());
                break;
            default:
                books = new ArrayList<>();
        }

        model.put("isBooksExists", !books.isEmpty());
        if (books.isEmpty()) {
            books = bookRepository.getAllBooksWhichInFavourite().stream().map(BookDto::from).collect(Collectors.toList());
        }

        model.addAttribute("search_string", searchString);
        model.addAttribute("list", books);

        return "books/books";
    }

    public void setAdmin(ModelMap model, UserDetails userDetails) {
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
