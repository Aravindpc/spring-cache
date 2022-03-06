package com.crudexample.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.crudexample.entity.Banks;

@Repository
public interface BankRepository extends JpaRepository<Banks,Long>{

}
