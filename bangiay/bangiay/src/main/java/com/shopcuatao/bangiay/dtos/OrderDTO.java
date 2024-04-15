package com.shopcuatao.bangiay.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderDTO {
    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("email")
    private String email;
    @JsonProperty("phone_number")
    private String phoneNumber;

    private String note;

    private String status;
    @Min(value = 0,message = "tong tien >0")
    @JsonProperty("total_money")
    private Float totalMoney;

    @JsonProperty("shipping_method")
    private String shippingMethod;

    @JsonProperty("shipping_adress")
    private String shippingAdress;

    @JsonProperty("shipping_date")
    private LocalDate shippingDate;


}
