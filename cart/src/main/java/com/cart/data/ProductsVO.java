package com.cart.data;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

//{stringHelper.getJakartaEEClassNameOrNot(${useJakartaEE},"NotNull")};
//        {stringHelper.getJakartaEEClassNameOrNot(${useJakartaEE},"NotBlank")};{stringHelper.getJakartaEEClassNameOrNot(${useJakartaEE},"NotEmpty")};


@Data
public class ProductsVO implements Serializable {
    private static final long serialVersionUID = 1L;

//    @NotNull(message = "pid can not null")
    private Integer pid;

    @NotNull(message = "pdesc can not null")
    private String pdesc;

    @NotNull(message = "pname can not null")
    private String pname;

}
