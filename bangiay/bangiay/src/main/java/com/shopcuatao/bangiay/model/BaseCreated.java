package com.shopcuatao.bangiay.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseCreated {

    @Column(name = "create_at")
    private LocalTime createdAt;

    @Column(name = "update_at")
    private LocalTime updatedAt;

    @PrePersist
    protected void onCreate(){
        createdAt = LocalTime.now();
        updatedAt = LocalTime.now();
    }
    @PreUpdate
    protected  void onUpdate(){
        updatedAt = LocalTime.now();
    }


}
