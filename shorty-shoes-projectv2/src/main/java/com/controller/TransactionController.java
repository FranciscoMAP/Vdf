package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Product;
import com.service.ProductService;
import com.service.TransactionService;

@Controller
public class TransactionController {

	@Autowired
	ProductService productService;
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping(value="insertTransaction")
	public String insertTransaction (Product pp, Model mm, @RequestParam("pid") int pid){
	//	pp = productService.searchProductById(pp.getPid());
		if (transactionService.insertTransaction(pid,1)) {
			mm.addAttribute("msgTransactionSucess", "Order placed");
		} else mm.addAttribute("msgTransactionError", "Error: This product don't have stock");
		mm.addAttribute("productFiltered", new Product());
		mm.addAttribute("products", productService.findAll());
		return "Customer";
	}
}
