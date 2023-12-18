package com.cart.data;


import lombok.Data;

import java.io.Serializable;

@Data
public class BrandsQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer bid;

    private String bname;

    private Integer pid;

}
