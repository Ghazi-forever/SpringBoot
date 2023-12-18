package com.cart.data;


import lombok.Data;

import java.io.Serializable;

@Data
public class SizeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer sid;

    private String avlbSize;

}
