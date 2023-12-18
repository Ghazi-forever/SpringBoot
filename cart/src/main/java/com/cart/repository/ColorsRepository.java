package com.cart.repository;

import com.cart.entity.Colors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ColorsRepository extends JpaRepository<Colors, Integer>, JpaSpecificationExecutor<Colors> {

}