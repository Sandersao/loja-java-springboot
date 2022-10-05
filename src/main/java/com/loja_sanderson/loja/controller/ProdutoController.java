package com.loja_sanderson.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja_sanderson.loja.exception.HttpException;
import com.loja_sanderson.loja.exception.NotFoundException;
import com.loja_sanderson.loja.request.ProdutoCreateRequest;
import com.loja_sanderson.loja.request.ProdutoUpdateRequest;
import com.loja_sanderson.loja.respose.CustomResponseBody;
import com.loja_sanderson.loja.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("")
    public CustomResponseBody produtoList() {
        CustomResponseBody responseBody = new CustomResponseBody();
        responseBody.getData()
                .setList(this.produtoService.produtoList());
        responseBody.setCode(200);
        responseBody.setMessage("Product list successfully retrived");
        return responseBody;
    }

    @GetMapping("/{id}")
    public CustomResponseBody produtoIndex(@PathVariable Integer id)
            throws NotFoundException {
        CustomResponseBody responseBody = new CustomResponseBody();
        responseBody.getData()
                .setList(this.produtoService.produtoIndex(id));
        responseBody.setCode(200);
        responseBody.setMessage("Product succesfully retrived");

        return responseBody;
    }

    @PostMapping("")
    public CustomResponseBody produtoCreate(@RequestBody ProdutoCreateRequest produtoCreateRequest) {
        CustomResponseBody responseBody = new CustomResponseBody();
        responseBody.getData()
                .setList(this.produtoService.produtoCreate(produtoCreateRequest));
        responseBody.setCode(201);
        responseBody.setMessage("Product successfuly created");
        return responseBody;
    }

    @PutMapping("/{id}")
    public CustomResponseBody produtoUpdate(@PathVariable Integer id,
            @RequestBody ProdutoUpdateRequest produtoUpdateRequest)
            throws HttpException {
        CustomResponseBody responseBody = new CustomResponseBody();

        responseBody
                .getData()
                .setList(this.produtoService.produtoUpdate(id, produtoUpdateRequest));
        responseBody.setCode(201);
        responseBody.setMessage("Product succesfully updated");

        return responseBody;
    }

    @DeleteMapping("/{id}")
    public CustomResponseBody produtoDelete(@PathVariable Integer id)
            throws NotFoundException {
        CustomResponseBody responseBody = new CustomResponseBody();

        responseBody.setCode(201);
        responseBody.getData()
                .setList(this.produtoService.produtoDelete(id));
        responseBody.setMessage("Product succesfully deleted");
        return responseBody;
    }
}
