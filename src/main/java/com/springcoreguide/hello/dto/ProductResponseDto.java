package com.springcoreguide.hello.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
    private Long number;
    private String name;
    private int price;
    private int stock;
}
