package com.shopcuatao.bangiay.Service;

import com.shopcuatao.bangiay.model.Role;
import com.shopcuatao.bangiay.repositories.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService{
    private final RoleRepo roleRepo;
    @Override
    public List<Role> getAll() {
        return roleRepo.findAll();
    }
}
