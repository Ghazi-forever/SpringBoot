package com.cart.data;


import lombok.Data;

import java.io.Serializable;

@Data
public class ColorsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer cid;

    private String colours;

    private Integer pid;

}
