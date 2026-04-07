package com.cart.service;

import com.cart.data.ColorsDTO;
import com.cart.data.ColorsQueryVO;
import com.cart.data.ColorsUpdateVO;
import com.cart.data.ColorsVO;
import com.cart.entity.Colors;
import com.cart.repository.ColorsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ColorsService {

    @Autowired
    private ColorsRepository colorsRepository;

    public Integer save(ColorsVO vO) {
        Colors bean = new Colors();
        BeanUtils.copyProperties(vO, bean);
        bean = colorsRepository.save(bean);
        return bean.getCid();
    }

    public void delete(Integer id) {
        colorsRepository.deleteById(id);
    }

    public void update(Integer id, ColorsUpdateVO vO) {
        Colors bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        colorsRepository.save(bean);
    }

    public ColorsDTO getById(Integer id) {
        Colors original = requireOne(id);
        return toDTO(original);
    }

    public Page<ColorsDTO> query(ColorsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ColorsDTO toDTO(Colors original) {
        ColorsDTO bean = new ColorsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Colors requireOne(Integer id) {
        return colorsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
