package com.shopcuatao.bangiay.Service;

import com.shopcuatao.bangiay.dtos.OrderDTO;
import com.shopcuatao.bangiay.dtos.OrderDetailDTO;
import com.shopcuatao.bangiay.exeption.DataNotFound;
import com.shopcuatao.bangiay.model.OrderDetails;
import com.shopcuatao.bangiay.model.Orders;

import java.util.List;

public interface IOrderDetailService {
    OrderDetails createOrder(OrderDetailDTO orderDetailDTO) throws DataNotFound;
    OrderDetails getOrderById(int id);

//    List<OrderDetails> findByUserId(int userId);
OrderDetails updateOrder(int id, OrderDetailDTO orderDetailDTO);

    void deleteOrder(int id);
}
