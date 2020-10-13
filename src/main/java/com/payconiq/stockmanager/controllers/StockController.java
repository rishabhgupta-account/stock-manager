package com.payconiq.stockmanager.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payconiq.stockmanager.models.Stock;
import com.payconiq.stockmanager.services.StockService;

/**
 * 
 * @author Rishabh Gupta
 *
 */

@RestController
@RequestMapping("/stocks")
public class StockController {
	
	@Autowired 
	private StockService stockService;
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Stock> getAllstocks(){	
		return this.stockService.getAllStocks();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public Stock getStockById(@PathVariable("id") Long id){
	    return stockService.getStockById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void saveStock(@RequestBody Stock stock){
		stock.setId(null);
		stockService.saveStock(stock);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/{id}")
	public void editStock(@RequestBody Stock editedStock ,@PathVariable("id") Long id){
		editedStock.setId(id);
		stockService.editStock(editedStock);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public void deleteStock(@PathVariable("id") Long id){
		stockService.deleteStock(id);
	}
		
}