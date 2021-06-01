package com.book.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.entity.Quote;

@Repository
@Transactional
public interface QuoteRepository extends JpaRepository<Quote, Long> {

	long deleteByQuote(String quote);


}
