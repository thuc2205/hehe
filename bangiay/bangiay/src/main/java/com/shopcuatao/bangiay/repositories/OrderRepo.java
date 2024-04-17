package com.shopcuatao.bangiay.repositories;

import com.shopcuatao.bangiay.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Orders,Integer> {
    List<Orders> findByUserId(int id);
}
