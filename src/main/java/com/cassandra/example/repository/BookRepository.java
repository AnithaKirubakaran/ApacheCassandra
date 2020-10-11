package com.cassandra.example.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.cassandra.example.model.Book;

public interface BookRepository extends CrudRepository<Book, UUID>{


}
