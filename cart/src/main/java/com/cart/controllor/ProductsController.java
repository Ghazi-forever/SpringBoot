package com.cart.controllor;

import com.cart.data.*;
import com.cart.service.ProductsService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @PostMapping
    public String save(@Valid @RequestBody ProductsVO vO) {
        System.out.println(vO.getPdesc()+" "+vO.getPname());
        return productsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        productsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody ProductsUpdateVO vO) {
        productsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ProductsDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return productsService.getById(id);
    }

    @GetMapping
    public Page<ProductsDTO> query(@Valid ProductsQueryVO vO) {
        return productsService.query(vO);
    }

    @PostMapping("/dynamicQuery")
    public List<ProductsVO> getDynamically(@RequestBody ProductsDynamicQuery query){
        System.out.println(query.getBrand()+" "+query.getColor()+" "+query.getSize());
        return productsService.getDynamically(query);
    }
}
