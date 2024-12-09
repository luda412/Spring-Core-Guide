package com.springcoreguide.hello.data.repository;

import com.springcoreguide.hello.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
