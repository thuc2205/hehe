package com.shopcuatao.bangiay.Service;

import com.shopcuatao.bangiay.dtos.SizeDTO;
import com.shopcuatao.bangiay.model.Sizes;
import com.shopcuatao.bangiay.repositories.SizeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SizeService implements ISizeService{
    private final SizeRepo sizeRepo;

    @Override
    public Sizes createSize(SizeDTO sizeDTO) {
        Sizes sizes = Sizes.builder()
                .name(sizeDTO.getName())
                .build();
        return sizeRepo.save(sizes);
    }

    @Override
    public Sizes getSizeById(int id) {
        return sizeRepo.findById(id)
                .orElseThrow(() -> new ResolutionException("Deo Tim Thay Size"));
    }

    @Override
    public List<Sizes> getAllSize() {
        return sizeRepo.findAll();
    }

    @Override
    public Sizes updateSize(int id, SizeDTO sizes) {
        Sizes existingSize = getSizeById(id);
        existingSize.setName(sizes.getName());
        return existingSize;
    }

    @Override
    public void deleteSize(int id) {
        sizeRepo.deleteById(id);
    }
}
