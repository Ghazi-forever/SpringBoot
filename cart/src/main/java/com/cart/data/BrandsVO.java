package com.cart.data;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

//{stringHelper.getJakartaEEClassNameOrNot(${useJakartaEE},"NotNull")};
//        {stringHelper.getJakartaEEClassNameOrNot(${useJakartaEE},"NotBlank")};{stringHelper.getJakartaEEClassNameOrNot(${useJakartaEE},"NotEmpty")};
//

@Data
public class BrandsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    //@NotNull(message = "bid can not null")
    private Integer bid;

    private String bname;

    private Integer pid;

}
