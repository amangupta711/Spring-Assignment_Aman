package com.example.demo;



import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface PageRepository extends JpaRepository<Page, Long> {

    List<Page> findByBook(Book book, Sort sort);
}
