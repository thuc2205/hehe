package com.shopcuatao.bangiay.responese;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shopcuatao.bangiay.model.ProductDetails;
import com.shopcuatao.bangiay.model.ProductImages;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private int id;

    private String name;

    private String thumbnail;
    private Float price;

    @JsonProperty("category_id")
    private int categoryId;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("update_at")
    private LocalDateTime updatedAt;

    private List<ProductImages> productImages = new ArrayList<>();

    public static ProductResponse fromProduct(ProductDetails products){
        ProductResponse productResponse = ProductResponse.builder()
                .id(products.getId())
                .name(products.getName())
                .price(products.getPrice())
                .categoryId(products.getCategories().getId())
                .productImages(products.getProductImages())
                .build();
        productResponse.setCreatedAt(products.getCreatedAt());
        productResponse.setUpdatedAt(products.getUpdatedAt());
        return productResponse;
    }

}
