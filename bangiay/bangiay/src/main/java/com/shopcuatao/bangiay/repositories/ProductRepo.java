package com.shopcuatao.bangiay.repositories;

import com.shopcuatao.bangiay.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Products,Integer> {
}
