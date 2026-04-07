package com.cart.service;

import com.cart.data.BrandsDTO;
import com.cart.data.BrandsQueryVO;
import com.cart.data.BrandsUpdateVO;
import com.cart.data.BrandsVO;
import com.cart.entity.Brands;
import com.cart.repository.BrandsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BrandsService {

    @Autowired
    private BrandsRepository brandsRepository;

    public Integer save(BrandsVO vO) {
        Brands bean = new Brands();
        BeanUtils.copyProperties(vO, bean);
        bean = brandsRepository.save(bean);
        return bean.getBid();
    }

    public void delete(Integer id) {
        brandsRepository.deleteById(id);
    }

    public void update(Integer id, BrandsUpdateVO vO) {
        Brands bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        brandsRepository.save(bean);
    }

    public BrandsDTO getById(Integer id) {
        Brands original = requireOne(id);
        return toDTO(original);
    }

    public Page<BrandsDTO> query(BrandsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private BrandsDTO toDTO(Brands original) {
        BrandsDTO bean = new BrandsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Brands requireOne(Integer id) {
        return brandsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
