package com.shopcuatao.bangiay.Service;

import com.shopcuatao.bangiay.dtos.BrandDTO;
import com.shopcuatao.bangiay.dtos.SizeDTO;
import com.shopcuatao.bangiay.model.Brand;
import com.shopcuatao.bangiay.model.Sizes;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IBrandService {
    Brand create(BrandDTO brandDTO);

    Brand getById(int id);

    public CompletableFuture<List<Brand>> getAll();

    Brand update(int id , BrandDTO brandDTO);

    void delete(int id);
}
