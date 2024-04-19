package com.shopcuatao.bangiay.Service;

import com.shopcuatao.bangiay.dtos.BrandDTO;
import com.shopcuatao.bangiay.dtos.ColorDTO;
import com.shopcuatao.bangiay.model.Brand;
import com.shopcuatao.bangiay.model.Colors;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IColorService {
    Colors create(ColorDTO brandDTO);

    Colors getById(int id);

    public CompletableFuture<List<Colors>> getAll();

    Colors update(int id , ColorDTO colorDTO);

    void delete(int id);
}
