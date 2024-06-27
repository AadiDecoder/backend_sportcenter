package com.ecommerce.sportcenter.service;

import com.ecommerce.sportcenter.entity.Brand;
import com.ecommerce.sportcenter.model.BrandResponse;
import com.ecommerce.sportcenter.repository.BrandRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class BrandServiceImpl implements BrandService{

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository){
        this.brandRepository=brandRepository;
    }
    @Override
    public List<BrandResponse> getAllBrands() {
        log.info("Fetching all brands!!!");
        List<Brand> brands = brandRepository.findAll();
        //now we use stream operator to map with response
        List<BrandResponse> brandResponses = brands.stream().map(this::convertToBrandResponse).collect(Collectors.toList());
        log.info("Fetched all Brands!!!");
        return brandResponses;
    }

    private BrandResponse convertToBrandResponse(Brand brand) {
        return BrandResponse.builder().id(brand.getId()).name(brand.getName()).build();
    }


}