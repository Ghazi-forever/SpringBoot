package com.cart.service;

import com.cart.data.SizeDTO;
import com.cart.data.SizeQueryVO;
import com.cart.data.SizeUpdateVO;
import com.cart.data.SizeVO;
import com.cart.entity.Size;
import com.cart.repository.SizeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SizeService {

    @Autowired
    private SizeRepository sizeRepository;

    public Integer save(SizeVO vO) {
        Size bean = new Size();
        BeanUtils.copyProperties(vO, bean);
        bean = sizeRepository.save(bean);
        return bean.getSid();
    }

    public void delete(Integer id) {
        sizeRepository.deleteById(id);
    }

    public void update(Integer id, SizeUpdateVO vO) {
        Size bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        sizeRepository.save(bean);
    }

    public SizeDTO getById(Integer id) {
        Size original = requireOne(id);
        return toDTO(original);
    }

    public Page<SizeDTO> query(SizeQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private SizeDTO toDTO(Size original) {
        SizeDTO bean = new SizeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Size requireOne(Integer id) {
        return sizeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
