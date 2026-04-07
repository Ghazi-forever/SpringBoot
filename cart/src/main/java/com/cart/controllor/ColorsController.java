package com.cart.controllor;

import com.cart.data.ColorsDTO;
import com.cart.data.ColorsQueryVO;
import com.cart.data.ColorsUpdateVO;
import com.cart.data.ColorsVO;
import com.cart.service.ColorsService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/colors")
public class ColorsController {

    @Autowired
    private ColorsService colorsService;

    @PostMapping
    public String save(@Valid @RequestBody ColorsVO vO) {
        return colorsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        colorsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody ColorsUpdateVO vO) {
        colorsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ColorsDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return colorsService.getById(id);
    }

    @GetMapping
    public Page<ColorsDTO> query(@Valid ColorsQueryVO vO) {
        return colorsService.query(vO);
    }
}
