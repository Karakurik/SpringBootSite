package ru.itis.karakurik.site.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String contentFileName;

    private int pageCount;

    @Column(unique = true, nullable = false)
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ToString.Exclude
    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id")
    )
    private List<Author> authors;

    private int publishDate;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    private Byte[] image;
}
