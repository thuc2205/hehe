package com.shopcuatao.bangiay.Service;

import com.shopcuatao.bangiay.dtos.ColorDTO;
import com.shopcuatao.bangiay.dtos.VoucherDTO;
import com.shopcuatao.bangiay.exeption.DataNotFound;
import com.shopcuatao.bangiay.model.Colors;
import com.shopcuatao.bangiay.model.Voucher;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IVoucherService {
    Voucher create(VoucherDTO voucherDTO);

    Voucher getById(int id) throws DataNotFound;

    public CompletableFuture<List<Voucher>> getAll();

    Voucher update(int id , VoucherDTO voucher);

    void delete(int id);
}
