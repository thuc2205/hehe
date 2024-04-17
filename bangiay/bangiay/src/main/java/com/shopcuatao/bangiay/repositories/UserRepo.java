package com.shopcuatao.bangiay.repositories;

import com.shopcuatao.bangiay.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
