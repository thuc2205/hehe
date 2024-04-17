package com.shopcuatao.bangiay.repositories;

import com.shopcuatao.bangiay.model.ProductDetails;
import com.shopcuatao.bangiay.model.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepo extends JpaRepository<ProductImages,Integer> {
    List<ProductImages> findByProductDetailsId(ProductDetails productDetails);


}
