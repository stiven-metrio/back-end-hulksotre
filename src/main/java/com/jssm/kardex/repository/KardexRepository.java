package com.jssm.kardex.repository;

import com.jssm.kardex.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KardexRepository extends JpaRepository<Product, Long> {
}
