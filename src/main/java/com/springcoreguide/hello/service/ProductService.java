package com.springcoreguide.hello.service;

import com.springcoreguide.hello.dto.ProductDto;
import com.springcoreguide.hello.dto.ProductResponseDto;

public interface ProductService {
    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}
