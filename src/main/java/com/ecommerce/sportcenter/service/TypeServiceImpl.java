package com.ecommerce.sportcenter.service;

import com.ecommerce.sportcenter.entity.Type;
import com.ecommerce.sportcenter.model.TypeResponse;
import com.ecommerce.sportcenter.repository.TypeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class TypeServiceImpl implements TypeService{

    private final TypeRepository typeRepository;
    public TypeServiceImpl(TypeRepository typeRepository) {
      this.typeRepository=typeRepository;
    }

    @Override
    public List<TypeResponse> getAllTypes() {
        //fetching all types.
        List<Type> allTypes = typeRepository.findAll();

        List<TypeResponse> typeResponses = allTypes.stream().map(this::convertToTypeResponse).collect(Collectors.toList());

        return typeResponses;
    }

    private TypeResponse convertToTypeResponse(Type type) {
        return TypeResponse.builder().id(type.getId()).name(type.getName()).build();
    }
}
