package com.cart.repository;

import com.cart.entity.Brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BrandsRepository extends JpaRepository<Brands, Integer>, JpaSpecificationExecutor<Brands> {

}