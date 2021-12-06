package com.example.graphql.data.repository;

import com.example.graphql.data.entity.Book;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>, JpaSpecificationExecutor<Book> {
}
