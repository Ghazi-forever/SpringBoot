package com.cart.service;

import com.cart.data.*;
import com.cart.entity.Products;
import com.cart.repository.BrandsRepository;
import com.cart.repository.ColorsRepository;
import com.cart.repository.ProductsRepository;
import com.cart.repository.SizeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private BrandsRepository brandsRepository;

    @Autowired
    private SizeRepository sizeRepository;

    @Autowired
    private ColorsRepository colorsRepository;

    public Integer save(ProductsVO vO) {
        Products bean = new Products();
        BeanUtils.copyProperties(vO, bean);
        bean = productsRepository.save(bean);
        return bean.getPid();
    }

    public void delete(Integer id) {
        productsRepository.deleteById(id);
    }

    public void update(Integer id, ProductsUpdateVO vO) {
        Products bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        productsRepository.save(bean);
    }

    public ProductsDTO getById(Integer id) {
        Products original = requireOne(id);
        return toDTO(original);
    }

    public Page<ProductsDTO> query(ProductsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ProductsDTO toDTO(Products original) {
        ProductsDTO bean = new ProductsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Products requireOne(Integer id) {
        return productsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    public List<ProductsVO> getDynamically(ProductsDynamicQuery query) {
        List<Products> productsList=null;
        List<ProductsVO> voList=new ArrayList<ProductsVO>();
        List<String> brand=null,size=null,color=null;

        if(query.getSize().size()<1){
            size=sizeRepository.findAll().stream().map(s->s.getAvlbSize()).collect(Collectors.toList());
        }else{
            size=query.getSize();
        }

        if(query.getColor().size()<1){
            color=colorsRepository.findAll().stream().map(c->c.getColours()).collect(Collectors.toList());
        }else{
            color=query.getColor();
        }

        if(query.getBrand().size()<1){
            brand=brandsRepository.findAll().stream().map(b->b.getBname()).collect(Collectors.toList());
        }else{
            brand=query.getBrand();
        }



        productsList=productsRepository.findByBrands_BnameInAndSizes_AvlbSizeInAndColors_ColoursIn(
                    brand,
                    size,
                    color
        );

        if(productsList!=null){
            for(Products product:productsList){
                ProductsVO vo=new ProductsVO();
                BeanUtils.copyProperties(product,vo);
                voList.add(vo);
            }

        }
        return voList;
    }
}
