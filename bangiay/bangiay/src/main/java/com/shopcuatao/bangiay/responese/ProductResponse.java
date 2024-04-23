package com.shopcuatao.bangiay.responese;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shopcuatao.bangiay.model.ProductImages;
import lombok.*;

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

    @JsonProperty("category_id")
    private int categoryId;

    private List<ProductImages> productImages = new ArrayList<>();

//    public static ProductResponse fromProduct(Products products){
//        ProductResponse productResponse = ProductResponse.builder()
//                .id(products.getId())
//                .name(products.getName())
//                .build();
//        return productResponse;
//    }

}
