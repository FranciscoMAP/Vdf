package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("select p from Product p where p.pbrand = :pbrand and p.pmodel = :pmodel")
	public Optional<Product> findProductByNameAndModel(@Param("pbrand") String pbrand, @Param("pmodel") String pmodel);
	
	
	@Query("select p from Product p where " +
			"(:ptype ='' or p.ptype = :ptype)"+
			"and (:pbrand ='' or p.pbrand =:pbrand)" +
			"and (:pmodel ='' or p.pmodel = :pmodel)"+//+
			"and (:pprice = 0.0 or p.pprice = :pprice)")
		//	)
	public List <Product> filterProduct(@Param("ptype") String ptype, @Param("pbrand") String pbrand, @Param("pmodel") String pmodel, @Param("pprice") float pprice);
}
