package com.cart.controllor;

import com.cart.data.SizeDTO;
import com.cart.data.SizeQueryVO;
import com.cart.data.SizeUpdateVO;
import com.cart.data.SizeVO;
import com.cart.service.SizeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/size")
public class SizeController {

    @Autowired
    private SizeService sizeService;

    @PostMapping
    public String save(@Valid @RequestBody SizeVO vO) {
        return sizeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        sizeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody SizeUpdateVO vO) {
        sizeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public SizeDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return sizeService.getById(id);
    }

    @GetMapping
    public Page<SizeDTO> query(@Valid SizeQueryVO vO) {
        return sizeService.query(vO);
    }
}
