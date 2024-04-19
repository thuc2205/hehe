package com.shopcuatao.bangiay.Service;

import com.shopcuatao.bangiay.dtos.ColorDTO;
import com.shopcuatao.bangiay.dtos.ProductDTO;
import com.shopcuatao.bangiay.model.Colors;
import com.shopcuatao.bangiay.model.Products;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IProductService {
    Products create(ProductDTO productDTO);

    Products getById(int id);

    public CompletableFuture<List<Products>> getAll();

    Products update(int id , ProductDTO productDTO);

    void delete(int id);
}
