package com.shopcuatao.bangiay.Service;

import com.shopcuatao.bangiay.dtos.SizeDTO;
import com.shopcuatao.bangiay.model.Sizes;

import java.util.List;

public interface ISizeService {
    Sizes createSize(SizeDTO sizeDTO);

    Sizes getSizeById(int id);

    List<Sizes> getAllSize();

    Sizes updateSize(int id , SizeDTO sizes);

    void deleteSize(int id);
}
