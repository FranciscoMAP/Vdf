package com.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.entity.Transaction;
import com.repository.ProductRepository;
import com.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	public boolean insertTransaction(int pid, int transactionQuantity) {
		if (transactionQuantity==0) return false;
		else {
			Transaction t = new Transaction();
			Optional<Product> transactionResult = productRepository.findById(pid);
			if (transactionResult.isPresent()) {
				Product p = transactionResult.get();
				if ( transactionQuantity <= p.getPquantity()) {
					p.setPquantity(p.getPquantity()-transactionQuantity); // update quantity for product
					productRepository.save(p);
					t.setQuantity(transactionQuantity);
					t.settDate(LocalDateTime.now());
					t.setValue(transactionQuantity * p.getPprice());
					t.setProduct(p);
					return true;
				}
			}else return false;
		}
		return false;
	}
	
	public List <Transaction> findAll() {return transactionRepository.findAll();

	}
}
