package com.cart.data;

import lombok.Data;

import java.util.List;

@Data
public class ProductsDynamicQuery {

    private List<String> brand;
    private List<String> size;
    private List<String> color;

}
