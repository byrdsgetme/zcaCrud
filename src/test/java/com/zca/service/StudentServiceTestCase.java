package com.zca.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentServiceTestCase {

    @Autowired
    private StudentService studentService;

    @Test
    void  test1()
    {
        System.out.println(studentService.getById(3));
    }

    @Test
    void  test2()
    {
        System.out.println(studentService.delete(1));
    }
}
