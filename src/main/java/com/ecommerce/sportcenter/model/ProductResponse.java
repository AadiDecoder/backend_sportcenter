package com.ecommerce.sportcenter.model;

import com.ecommerce.sportcenter.entity.Brand;
import com.ecommerce.sportcenter.entity.Type;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private Integer id;
    private String name;
    private String description;
    private long price;
    private String pictureUrl;
    private String brand;
    private String type;
}
