package com.zca.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zca.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentDaoTestCase {
    @Autowired
    private StudentDao studentDao;


    @Test
    void testGetById()
    {
        System.out.println(studentDao.selectById(1));
    }

    @Test
    void testSave()
    {
        Student student =new Student();
        student.setGrade(2019);
        student.setSex(0);
        student.setStudName("brian");
        studentDao.insert(student);
    }

    @Test
    void testUpdate()
    {
        Student student =new Student();
        student.setSid(9);
        student.setGrade(2020);
        studentDao.updateById(student);
    }

    @Test
    void testDelete()
    {
        studentDao.deleteById(9);
    }

    @Test
    void testAll()
    {
        System.out.println(studentDao.selectList(null));
    }

    @Test
    void testGetPage()
    {
        IPage<Student> page= new Page(2,5);
        studentDao.selectPage(page,null);
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
    }

    @Test
    void testGetBy()
    {
        String name="t";
        LambdaQueryWrapper<Student> lqw= new LambdaQueryWrapper<Student>();
        lqw.like(name !=null,Student::getStudName,name);
        studentDao.selectList(lqw);
    }
}
