package com.cart.data;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

//{stringHelper.getJakartaEEClassNameOrNot(${useJakartaEE},"NotNull")};
//        {stringHelper.getJakartaEEClassNameOrNot(${useJakartaEE},"NotBlank")};{stringHelper.getJakartaEEClassNameOrNot(${useJakartaEE},"NotEmpty")};


@Data
public class SizeVO implements Serializable {
    private static final long serialVersionUID = 1L;

    //@NotNull(message = "sid can not null")
    private Integer sid;

    private String avlbSize;

}
