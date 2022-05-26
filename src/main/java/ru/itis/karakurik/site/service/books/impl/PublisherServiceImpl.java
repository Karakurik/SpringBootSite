package ru.itis.karakurik.site.service.books.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.karakurik.site.dto.books.PublisherDto;
import ru.itis.karakurik.site.exception.books.PublisherNotFoundException;
import ru.itis.karakurik.site.repository.jpa.PublisherRepository;
import ru.itis.karakurik.site.service.books.interfaces.PublisherService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;

    @Override
    public List<PublisherDto> getPublisherList() {
        return publisherRepository.findAll().stream()
                .map(PublisherDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public PublisherDto find(String name) {
        return PublisherDto.from(publisherRepository.findPublisherByName(name).orElseThrow(PublisherNotFoundException::new));
    }
}
