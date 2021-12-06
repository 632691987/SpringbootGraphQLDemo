package com.example.graphql.config;

import com.example.graphql.data.entity.Author;
import com.example.graphql.data.entity.Book;
import com.example.graphql.data.repository.AuthorRepository;
import com.example.graphql.data.repository.BookRepository;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

@Component
public record GraphQLDataFetchers(BookRepository bookRepository, AuthorRepository authorRepository) {

    public DataFetcher<Book> getBookByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("id");
            return bookRepository.findById(Long.parseLong(bookId)).orElse(null);
        };
    }

    public DataFetcher<Author> getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            Book book = dataFetchingEnvironment.getSource();
            Long authorId = book.getAuthor().getId();
            return authorRepository.findById(authorId).orElse(null);
        };
    }
}