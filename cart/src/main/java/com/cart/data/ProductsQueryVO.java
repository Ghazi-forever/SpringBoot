package com.cart.data;


import lombok.Data;

import java.io.Serializable;

@Data
public class ProductsQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer pid;

    private String pdesc;

    private String pname;

}
