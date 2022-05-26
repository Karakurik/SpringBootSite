package ru.itis.karakurik.site.dto.books;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchForm {
    private String searchString;
    private String searchOption;
}
