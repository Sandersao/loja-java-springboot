package com.loja_sanderson.loja.respose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomResponseBody {
    private Integer code;
    private CustomResponseBodyData data = new CustomResponseBodyData();
    private String message;
}
