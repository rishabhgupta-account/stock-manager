package com.payconiq.stockmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payconiq.stockmanager.models.Stock;


/**
 * 
 * @author Rishabh Gupta
 *
 */

public interface StockRepository extends JpaRepository<Stock, Long> {
	
	public List<Stock> findAll();
	
	public Stock findById(Long id);

}
