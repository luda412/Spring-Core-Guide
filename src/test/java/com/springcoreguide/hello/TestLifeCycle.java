package com.springcoreguide.hello;

import org.junit.jupiter.api.*;

public class TestLifeCycle {
    @BeforeAll
    static void beforeAll(){
        System.out.println("## BeforeAll 호출");
        System.out.println();
    }
    @AfterAll
    static void afterAll(){
        System.out.println("## AfterAll 호출");
        System.out.println();
    }
    @BeforeEach
    void beforeEach(){
        System.out.println("## BeforeEach 호출");
        System.out.println();
    }
    @AfterEach
    void afterEach(){
        System.out.println("## AfgerEach 호출");
        System.out.println();
    }
    @Test
    void test1(){
        System.out.println("## Test1 시작");
        System.out.println();
    }
    @Test
    @DisplayName("Test2 !")
    void test2(){
        System.out.println("## Test2 시작");
        System.out.println();
    }
    @Test
    @Disabled
    void test3(){
        System.out.println("## Test3 시작");
        System.out.println();
    }
}
