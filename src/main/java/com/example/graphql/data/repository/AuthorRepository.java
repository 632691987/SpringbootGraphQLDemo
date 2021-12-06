package com.example.graphql.data.repository;

import com.example.graphql.data.entity.Author;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>, JpaSpecificationExecutor<Author> {
}
