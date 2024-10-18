package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Login;

import jakarta.transaction.Transactional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{
	
	@Query("select l from Login l where l.emailid = :emailid")
	public Optional<Login> findLoginByEmail(@Param("emailid") String emailid);

	
	@Query("select l from Login l where l.emailid = :emailid and l.emailpassword =:emailpassword")
	public Optional<Login> findLoginByEmailAndPassword(@Param("emailid") String emailid,@Param("emailpassword") String emailpassword); ;
	
	@Modifying
	@Transactional
	@Query("update Login l set l.emailpassword=:emailpassword where l.emailid='admin@gmail.com'")
	public int updateAdminPassword(@Param("emailpassword") String emailpassword);
}
