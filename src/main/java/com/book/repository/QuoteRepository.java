package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.entity.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

}
