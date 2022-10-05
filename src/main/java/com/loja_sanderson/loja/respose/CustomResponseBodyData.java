package com.loja_sanderson.loja.respose;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponseBodyData {
    private Integer qtdeTotal;
    private Integer qtde;
    private Integer start;
    private Integer end;
    private List list = new ArrayList<>();

    public void setList(List list) {
        this.list = list;
        this.qtde = list.size();
    }
}
