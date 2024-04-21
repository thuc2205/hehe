package com.shopcuatao.bangiay.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductDetailDTO {
    @JsonProperty("product_id")
    private int productID;

    @JsonProperty("color_id")
    private int colorId;

    @JsonProperty("size_id")
    private int sizeId;

    @JsonProperty("category_id")
    private int categoryId;

    @JsonProperty("brand_id")
    private int brandId;

    @JsonProperty("xuatxu_id")
    private int xuatxuId;

    private String thumbnail;

    private String description;

    private int quantity;

    private Float price;

}
