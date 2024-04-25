package com.shopcuatao.bangiay.responese;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductListRespones {
    private List<ProductResponse> productResponses;
    private int totalPage;
}
