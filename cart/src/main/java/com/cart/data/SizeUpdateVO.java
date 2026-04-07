package com.cart.data;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class SizeUpdateVO extends SizeVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
