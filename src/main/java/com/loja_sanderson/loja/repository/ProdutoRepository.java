package com.loja_sanderson.loja.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.loja_sanderson.loja.exception.HttpException;
import com.loja_sanderson.loja.exception.NotFoundException;
import com.loja_sanderson.loja.model.ProdutoModel;

@Component
public class ProdutoRepository {
    public List<ProdutoModel> produtoListar() {
        List<ProdutoModel> produtoList = new ArrayList<>();

        ProdutoModel produto = new ProdutoModel();
        produto.setId(1);
        produto.setNome("Mashmellow");
        produto.setPreco(0.0);
        produtoList.add(produto);

        produto = new ProdutoModel();
        produto.setId(2);
        produto.setNome("Fini");
        produto.setPreco(0.0);
        produtoList.add(produto);

        return produtoList;
    }

    public List<ProdutoModel> produtoIndex(Integer id) throws NotFoundException {
        if (!id.equals(1) && !id.equals(2)) {
            throw new NotFoundException("Unable to find product");
        }

        List<ProdutoModel> produtoList = new ArrayList<>();

        ProdutoModel produto = new ProdutoModel();
        produto.setId(1);
        produto.setNome("Mashmellow");
        produto.setPreco(0.0);
        produtoList.add(produto);

        produto = new ProdutoModel();
        produto.setId(2);
        produto.setNome("Fini");
        produto.setPreco(0.0);
        produtoList.add(produto);

        for (int i = 0; i < produtoList.size(); i++) {
            if (!produtoList.get(i).getId().equals(id)) {
                produtoList.remove(i);
            }
        }

        return produtoList;
    }

    public List<ProdutoModel> produtoCreate(ProdutoModel produtoModel) {
        List<ProdutoModel> produtoModelList = new ArrayList<>();
        ProdutoModel produtoModelCreate = new ProdutoModel();
        produtoModelCreate.setId(3);
        produtoModelCreate.setNome(produtoModel.getNome());
        produtoModelCreate.setPreco(produtoModel.getPreco());
        produtoModelList.add(produtoModelCreate);
        return produtoModelList;
    }

    public List<ProdutoModel> produtoUpdate(ProdutoModel produtoModel) {
        List<ProdutoModel> produtoModelList = new ArrayList<>();
        ProdutoModel produtoModelCreate = new ProdutoModel();
        produtoModelCreate.setId(produtoModel.getId());
        produtoModelCreate.setNome(produtoModel.getNome());
        produtoModelCreate.setPreco(produtoModel.getPreco());
        produtoModelList.add(produtoModelCreate);
        return produtoModelList;
    }

    public boolean produtoDelete(Integer id) {
        return true;
    }
}
