package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Product;
import com.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

//	@Query("select t from Transaction t inner join t.product where :type ='' or p.type =:type")
//	public List<Transaction> findTransactionByType(@Param("type") String type);
}
