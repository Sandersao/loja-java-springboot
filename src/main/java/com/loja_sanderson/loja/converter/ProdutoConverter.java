package com.loja_sanderson.loja.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.loja_sanderson.loja.model.ProdutoModel;
import com.loja_sanderson.loja.request.ProdutoCreateRequest;
import com.loja_sanderson.loja.request.ProdutoUpdateRequest;
import com.loja_sanderson.loja.respose.ProdutoResponse;

@Component
public class ProdutoConverter {
    public List<ProdutoResponse> produtoModelListToProdutoResponseList(List<ProdutoModel> produtoModelList) {
        List<ProdutoResponse> produtoResponseList = new ArrayList<>();
        for (ProdutoModel produtoModel : produtoModelList) {
            produtoResponseList.add(
                    this.produtoModelToProdutoResponse(produtoModel));
        }
        return produtoResponseList;
    }

    public ProdutoResponse produtoModelToProdutoResponse(ProdutoModel produtoModel) {
        return new ProdutoResponse(
                produtoModel.getId(),
                produtoModel.getNome(),
                produtoModel.getPreco());
    }

    public ProdutoModel produtoCreateRequestToProdutoModel(ProdutoCreateRequest produtoCreateRequest) {
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setNome(produtoCreateRequest.getNome());
        produtoModel.setPreco(produtoCreateRequest.getPreco());
        return produtoModel;
    }

    public ProdutoModel produtoUpdateRequestToProdutoModel(Integer id, ProdutoUpdateRequest produtoUpdateRequest) {
        return new ProdutoModel(
                id,
                produtoUpdateRequest.getNome(),
                produtoUpdateRequest.getPreco());
    }
}
