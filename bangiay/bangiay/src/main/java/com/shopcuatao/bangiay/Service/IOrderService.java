package com.shopcuatao.bangiay.Service;

import com.shopcuatao.bangiay.dtos.OrderDTO;
import com.shopcuatao.bangiay.model.Orders;

import java.util.List;

public interface IOrderService {
    Orders createOrder(OrderDTO orderDTO)throws Exception;

    Orders getOrderById(int id);

    List<Orders>findByUserId(int userId);
    Orders updateOrder(int id, OrderDTO orderDTO);

    void deleteOrder(int id);
}
