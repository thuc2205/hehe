package com.shopcuatao.bangiay.Service;

import com.shopcuatao.bangiay.dtos.ProductDTO;
import com.shopcuatao.bangiay.model.Products;
import com.shopcuatao.bangiay.repositories.ProductRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService{
    private final ProductRepo productRepo;
    @Transactional
    @Override
    public Products create(ProductDTO productDTO) {
        Products products = Products.builder()
                .name(productDTO.getName())
                .codeProduct(ranDomMaProduct())
                .build();
        return productRepo.save(products);
    }

    private String ranDomMaProduct(){
        Random random = new Random();
        StringBuilder resultBuilder = new StringBuilder("SP");

        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(10);
            resultBuilder.append(randomNumber);
        }

        return resultBuilder.toString();
    }

    @Override
    public Products getById(int id) {
        return productRepo.findById(id).orElseThrow(() -> new ResolutionException("Khong tim thay id san pham"));
    }

    @Override
    public CompletableFuture<List<Products>> getAll() {
        return CompletableFuture.completedFuture(productRepo.findAll());
    }

    @Transactional
    @Override
    public Products update(int id, ProductDTO productDTO) {
        Products existingProduct = getById(id);
        existingProduct.setName(productDTO.getName());
        return existingProduct;
    }
    @Transactional
    @Override
    public void delete(int id) {
        Products existingProduct = getById(id);
        productRepo.delete(existingProduct);
    }
}
