package com.shopcuatao.bangiay.repositories;

import com.shopcuatao.bangiay.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderdetailRepo extends JpaRepository<OrderDetails,Integer> {
    List<OrderDetails> findByOrderId(int id);
}
