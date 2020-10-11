package com.cassandra.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.springframework.web.bind.annotation.RestController;

import com.cassandra.example.model.Book;
import com.cassandra.example.repository.BookRepository;
import com.datastax.driver.core.utils.UUIDs;

@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api")
@RestController
public class CassandraController {

	@Autowired
	private BookRepository bookRepository;

	@RequestMapping(value = "/books", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public List<Book> getAllBooks() {

		Iterable<Book> result = bookRepository.findAll();
		List<Book> bookslist = new ArrayList<Book>();

		result.forEach(bookslist::add);
		return bookslist;

	}

	@RequestMapping(value = "/books", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Book createBook(@RequestBody Book book) {

		Book book1 = bookRepository.save(new Book(UUIDs.timeBased(), book.getTitle(), book.getDescription(), false));
		return book1;

	}

	@GetMapping("/webs")
	public String welcome() {
		return "hi";
	}
}
