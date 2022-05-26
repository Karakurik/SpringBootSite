package ru.itis.karakurik.site.service.books.interfaces;

import ru.itis.karakurik.site.dto.books.PublisherDto;

import java.util.List;

public interface PublisherService {
    List<PublisherDto> getPublisherList();

    PublisherDto find(String name);
}
