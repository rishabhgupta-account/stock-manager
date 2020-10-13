package com.payconiq.stockmanager.services;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payconiq.stockmanager.models.Stock;
import com.payconiq.stockmanager.repositories.StockRepository;

/**
 * 
 * @author Rishabh Gupta
 *
 */

@Service
public class StockService {
	
	@Autowired 
	private StockRepository stockRepository;

	public Collection<Stock> getAllStocks() {
		Collection<Stock> stocks = stockRepository.findAll();
		return stocks;
	}

	public Stock getStockById(Long id) {
		return stockRepository.findById(id);
	}

	public void saveStock(Stock stock) {
		stock.setId(null);
		stock.setLastUpdatedAt(new Date());
		stockRepository.save(stock);
	}

	public void editStock(Stock editedStock) {
		editedStock.setLastUpdatedAt(new Date());
		stockRepository.saveAndFlush(editedStock);
	}

	public void deleteStock(Long id) {
		stockRepository.delete(id);
	}
		
}