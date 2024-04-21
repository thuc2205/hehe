package com.shopcuatao.bangiay.Service;

import com.shopcuatao.bangiay.dtos.CategoriesDto;
import com.shopcuatao.bangiay.dtos.ColorDTO;
import com.shopcuatao.bangiay.model.Categories;
import com.shopcuatao.bangiay.model.Colors;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ICategoryService {
    Categories create(CategoriesDto categoriesDto);

    Categories getById(int id);

    public CompletableFuture<List<Categories>> getAll();

    Categories update(int id , CategoriesDto categoriesDto);

    void delete(int id);
}
