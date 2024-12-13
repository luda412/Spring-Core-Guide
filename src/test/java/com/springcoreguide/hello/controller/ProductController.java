//package com.springcoreguide.hello.controller;
//
//import com.springcoreguide.hello.dto.ProductResponseDto;
//import com.springcoreguide.hello.service.impl.ProductServiceImpl;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.verify;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//@WebMvcTest(ProductController.class)
//public class ProductController {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ProductServiceImpl productService;
//
//    @Test
//    @DisplayName("MockMvc를 통한 Product 데이터 가져오기 테스트")
//    void getProductTest() throws Exception {
//        given(productService.getProduct(123L)).willReturn(
//                new ProductResponseDto(123L, "pen", 5000, 2000)
//        );
//
//        String productId = "123";
//
//        mockMvc.perform(get("/product?number/" + productId))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.number").value(123L))
//                .andExpect(jsonPath("$.name").value("pen"))
//                .andExpect(jsonPath("$.price").value(5000))
//                .andExpect(jsonPath("$.stock").value(2000))
//                .andDo(print());
//
//        verify(productService).getProduct(123L);
//    }
//}
