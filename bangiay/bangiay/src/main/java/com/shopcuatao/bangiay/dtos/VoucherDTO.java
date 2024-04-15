package com.shopcuatao.bangiay.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VoucherDTO {
    @JsonProperty("code_voucher")
    @NotNull(message = "Khong trong ma voucher")
    private String codeVoucher;

    @JsonProperty("name_km")
    private String nameKm;

    @JsonProperty("gia_tri_toi_thieu")
    @Min(value = 0,message = "gia tri toi thieu lon hon > 0")
    private Float giaTriToiThieu;

    @JsonProperty("giam_gia")
    private Float giamGia;

    private int quantify;

    @JsonProperty("start_day")
    private Date startDay;

    @JsonProperty("end_day")
    private Date endDay;

    private String status;
}
