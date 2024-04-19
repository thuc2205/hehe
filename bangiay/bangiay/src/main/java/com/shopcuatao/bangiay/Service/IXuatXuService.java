package com.shopcuatao.bangiay.Service;

import com.shopcuatao.bangiay.dtos.ColorDTO;
import com.shopcuatao.bangiay.dtos.XuatXuDTO;
import com.shopcuatao.bangiay.model.Colors;
import com.shopcuatao.bangiay.model.XuatXu;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IXuatXuService {
    XuatXu create(XuatXuDTO xuatXuDTO);

    XuatXu getById(int id);

    public CompletableFuture<List<XuatXu>> getAll();

    XuatXu update(int id , XuatXuDTO xuatXuDTO);

    void delete(int id);
}
