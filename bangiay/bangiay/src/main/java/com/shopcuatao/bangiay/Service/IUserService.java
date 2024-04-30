package com.shopcuatao.bangiay.Service;

import com.shopcuatao.bangiay.dtos.UserDTO;
import com.shopcuatao.bangiay.exeption.DataNotFound;
import com.shopcuatao.bangiay.model.User;

public interface IUserService {
    User createUser(UserDTO userDTO) throws DataNotFound;

    String login(String phoneNumber,String password) throws Exception;
}
