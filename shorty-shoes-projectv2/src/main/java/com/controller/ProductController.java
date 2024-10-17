package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Product;
import com.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping(value="addProduct")
	public String addProduct (Product pp, Model mm, @RequestParam("selectionButton") String buttonValue){
		if(buttonValue.equals("Add product")) {
			
		boolean result = productService.storeProduct(pp);
		if (result) {
			mm.addAttribute("msgProductMgmtSuccess", "Product sucessfuly added");
		}
		else {
			mm.addAttribute("msgProductMgmtError", "Product already exist");
		}
		mm.addAttribute("product_mgmt", new Product());
		mm.addAttribute("buttonText", "Add product");
	//	mm.addAttribute("buttonText2", "Delete product");
		mm.addAttribute("products",productService.findAll());
		}
		else {
			if (productService.updateProduct(pp)) {
				mm.addAttribute("msgProductMgmtSuccess", "Product updated");
			} else mm.addAttribute("msgProductMgmtError", "Error trying to update product");
		}
		mm.addAttribute("buttonText", "Add product");
		mm.addAttribute("products",productService.findAll());
		mm.addAttribute("product_mgmt", new Product());
		return "Admin";
	}
		
	
	@GetMapping(value="deleteProduct")
	public String deleteProduct (Product pp,Model mm, @RequestParam("pid") int pid) {
		if (productService.deleteProduct(pp.getPid())){
			mm.addAttribute("msgProductMgmtSuccess", "Product deleted");			
		}
		else {
			mm.addAttribute("msgProductMgmtError", "Product not deleted");
		}
		mm.addAttribute("product_mgmt", new Product());
		mm.addAttribute("buttonText", "Add product");
		//mm.addAttribute("buttonText2", "Delete product");
		mm.addAttribute("products",productService.findAll());
		return "Admin";
	}

	@GetMapping(value="updateProductInfo")
	public String getProductInfo(Product pp, Model mm, @RequestParam("pid") int pid) {
		pp = productService.searchProductById(pp.getPid());
		mm.addAttribute("product_mgmt", pp);
		mm.addAttribute("products",productService.findAll());
		mm.addAttribute("buttonText", "Update Product");
		
		return "Admin";
	}
	
	
	@GetMapping(value="filterProducts")
	public String filterProducts(Product pp, Model mm) {
		if (pp.getPtype().isEmpty() && pp.getPbrand().isEmpty() && pp.getPmodel().isEmpty() && pp.getPprice()==0.0){  //nothing to filter
			mm.addAttribute("products",productService.findAll());
		} else {
			mm.addAttribute("products", productService.filterProducts(pp));
		}
		mm.addAttribute("productFiltered", pp);
		return "Customer";
	}
}
	
	
