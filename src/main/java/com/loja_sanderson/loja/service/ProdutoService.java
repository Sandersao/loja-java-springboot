package com.loja_sanderson.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.loja_sanderson.loja.converter.ProdutoConverter;
import com.loja_sanderson.loja.exception.HttpException;
import com.loja_sanderson.loja.exception.NotFoundException;
import com.loja_sanderson.loja.model.ProdutoModel;
import com.loja_sanderson.loja.repository.ProdutoRepository;
import com.loja_sanderson.loja.request.ProdutoCreateRequest;
import com.loja_sanderson.loja.request.ProdutoUpdateRequest;
import com.loja_sanderson.loja.respose.ProdutoResponse;

@Component
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoConverter produtoConverter;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoConverter produtoConverter) {
        this.produtoRepository = produtoRepository;
        this.produtoConverter = produtoConverter;
    }

    public List<ProdutoResponse> produtoList() {
        return this.produtoConverter.produtoModelListToProdutoResponseList(
                this.produtoRepository.produtoListar());
    }

    public List<ProdutoResponse> produtoIndex(Integer id)
            throws NotFoundException {
        return this.produtoConverter.produtoModelListToProdutoResponseList(
                this.produtoRepository.produtoIndex(id));
    }

    public List<ProdutoResponse> produtoCreate(ProdutoCreateRequest produtoCreateRequest) {
        ProdutoModel produtoModel = this.produtoConverter
                .produtoCreateRequestToProdutoModel(produtoCreateRequest);
        return this.produtoConverter
                .produtoModelListToProdutoResponseList(
                        this.produtoRepository.produtoCreate(produtoModel));
    }

    public List<ProdutoResponse> produtoUpdate(Integer id, ProdutoUpdateRequest produtoUpdateRequest)
            throws HttpException {
        this.produtoRepository.produtoIndex(id);
        ProdutoModel produtoModel = this.produtoConverter.produtoUpdateRequestToProdutoModel(id,
                produtoUpdateRequest);
        return this.produtoConverter.produtoModelListToProdutoResponseList(
                this.produtoRepository.produtoUpdate(produtoModel));
    }

    public List<ProdutoResponse> produtoDelete(Integer id)
            throws NotFoundException {
        List<ProdutoModel> produtoModelList = this.produtoRepository.produtoIndex(id);
        this.produtoRepository.produtoDelete(id);
        return this.produtoConverter
                .produtoModelListToProdutoResponseList(produtoModelList);
    }
}
