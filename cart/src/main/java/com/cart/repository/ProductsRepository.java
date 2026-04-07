package com.cart.repository;

import com.cart.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Integer>, JpaSpecificationExecutor<Products> {

    List<Products> findByBrands_BnameAndSizes_AvlbSizeAndColors_Colours(String brand, String size, String color);

    List<Products> findByBrands_BnameInAndSizes_AvlbSizeInAndColors_ColoursIn(List<String> brand, List<String> size, List<String> color);
}