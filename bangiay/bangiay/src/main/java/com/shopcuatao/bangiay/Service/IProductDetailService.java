package com.shopcuatao.bangiay.Service;

import com.shopcuatao.bangiay.dtos.ProductDetailDTO;
import com.shopcuatao.bangiay.dtos.ProductImageDTO;
import com.shopcuatao.bangiay.model.ProductDetails;
import com.shopcuatao.bangiay.model.ProductImages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IProductDetailService {
    public ProductDetails create(ProductDetailDTO productDetailDTO) throws Exception;

    Page<ProductDetails> getAllProduct(PageRequest pageRequest);

    public List<ProductDetails> findProductsById(List<Integer> productId);

    public ProductDetails getProductsById(int productId);

    ProductImages createProductImage(int productId, ProductImageDTO productImageDTO) throws IllegalAccessException;
}
