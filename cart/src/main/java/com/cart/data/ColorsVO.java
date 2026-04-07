package com.cart.data;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

//{stringHelper.getJakartaEEClassNameOrNot(${useJakartaEE},"NotNull")};
//        {stringHelper.getJakartaEEClassNameOrNot(${useJakartaEE},"NotBlank")};{stringHelper.getJakartaEEClassNameOrNot(${useJakartaEE},"NotEmpty")};


@Data
public class ColorsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    //@NotNull(message = "cid can not null")
    private Integer cid;

    private String colours;

    private Integer pid;

}
