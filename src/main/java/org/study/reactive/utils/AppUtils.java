package org.study.reactive.utils;

import org.springframework.beans.BeanUtils;
import org.study.reactive.dto.ProductDto;
import org.study.reactive.model.Product;

public class AppUtils {

    public static ProductDto entityToDto(Product product) {

        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public static Product dtoToEntity(ProductDto dto) {

        Product product = new Product();
        BeanUtils.copyProperties(dto, product);
        return product;
    }
}
