package com.cart.controllor;

import com.cart.data.BrandsDTO;
import com.cart.data.BrandsQueryVO;
import com.cart.data.BrandsUpdateVO;
import com.cart.data.BrandsVO;
import com.cart.service.BrandsService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/brands")
public class BrandsController {

    @Autowired
    private BrandsService brandsService;

    @PostMapping
    public String save(@Valid @RequestBody BrandsVO vO) {
        return brandsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        brandsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody BrandsUpdateVO vO) {
        brandsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public BrandsDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return brandsService.getById(id);
    }

    @GetMapping
    public Page<BrandsDTO> query(@Valid BrandsQueryVO vO) {
        return brandsService.query(vO);
    }
}
