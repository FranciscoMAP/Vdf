package com.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public boolean storeProduct(Product product) {
		Optional <Product> productResult = productRepository.findProductByNameAndModel(product.getPbrand(),product.getPmodel());
		if (productResult.isPresent())return false;
		else {
			productRepository.saveAndFlush(product);
			return true;
		}
	}	
	public boolean deleteProduct(int pid) {
		Optional <Product> productResult = productRepository.findById(pid);
		if (productResult.isPresent()) {
			productRepository.deleteById(pid);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean updateProduct(Product productUpdated) {
		Optional <Product> productResult = productRepository.findById(productUpdated.getPid());
		if (productResult.isPresent()) {
			Product p =productResult.get();
			p.setPtype(productUpdated.getPtype());
			p.setPbrand(productUpdated.getPbrand());
			p.setPmodel(productUpdated.getPmodel());
			p.setPprice(productUpdated.getPprice());
			p.setPimage(productUpdated.getPimage());
			p.setPquantity(productUpdated.getPquantity());
			productRepository.saveAndFlush(p);
			return true;
		}
		return false;
		
	}
	
	public List <Product> findAll() {return productRepository.findAll();}
	
	public Product searchProductById (int pid) {
		Optional <Product> productResult = productRepository.findById(pid);
		if (productResult.isPresent()) return productResult.get();
		else return new Product();
		}
	
	public List <Product> filterProducts( Product product){
		//System.out.println(productRepository.filterProduct(product.getPtype(), product.getPbrand(), product.getPmodel(), product.getPprice()));
		return productRepository.filterProduct(product.getPtype(), product.getPbrand(), product.getPmodel(), product.getPprice());
	}
}
