package com.shopcuatao.bangiay.repositories;

import com.shopcuatao.bangiay.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Categories,Integer> {
}
