package com.shopcuatao.bangiay.Service;

import com.shopcuatao.bangiay.dtos.ProductDetailDTO;
import com.shopcuatao.bangiay.dtos.ProductImageDTO;
import com.shopcuatao.bangiay.model.*;
import com.shopcuatao.bangiay.repositories.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductDetaiServiceimpl implements IProductDetailService{

    private final BrandRepo brandRepo;
    private final ColorRepo colorRepo;
    private final XuatXuRepo xuatXuRepo;
    private final SizeRepo sizeRepo;
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;
    private final ProductDetailRepo productDetailRepo;
    @Override
    @Transactional
    public ProductDetails create(ProductDetailDTO productDetailDTO) throws Exception {
        Products product = productRepo.findById(productDetailDTO.getProductID())
                .orElseThrow(() -> new ResolutionException("Khong thay product id : " + productDetailDTO.getProductID()));
        Colors color = colorRepo.findById(productDetailDTO.getColorId()).orElse(null);
        Brand brand = brandRepo.findById(productDetailDTO.getBrandId()).orElse(null);
        Sizes size = sizeRepo.findById(productDetailDTO.getSizeId()).orElse(null);
        XuatXu xuatXu = xuatXuRepo.findById(productDetailDTO.getXuatxuId()).orElse(null);
        Categories categories = categoryRepo.findById(productDetailDTO.getCategoryId()).orElse(null);

        ProductDetails newProductDetail = ProductDetails.builder()
                .products(product)
                .colors(color)
                .brand(brand)
                .sizes(size)
                .xuatXu(xuatXu)
                .price(productDetailDTO.getPrice())
                .categories(categories)
                .quantity(productDetailDTO.getQuantity())
                .description(productDetailDTO.getDescription())
                .thumbnail("")
                .build();

        return productDetailRepo.save(newProductDetail);
    }

    @Override
    public Page<ProductDetails> getAllProduct(PageRequest pageRequest) {
        return null;
    }

    @Override
    public List<ProductDetails> findProductsById(List<Integer> productId) {
        return null;
    }

    @Override
    public ProductImages createProductImage(int productId, ProductImageDTO productImageDTO) {
        return null;
    }
}
