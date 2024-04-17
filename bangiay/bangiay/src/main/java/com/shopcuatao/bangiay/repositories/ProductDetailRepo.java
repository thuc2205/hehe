package com.shopcuatao.bangiay.repositories;

import com.shopcuatao.bangiay.model.ProductDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepo extends JpaRepository<ProductDetails,Integer> {

    Page<ProductDetails> finAll(Pageable pageable);
}