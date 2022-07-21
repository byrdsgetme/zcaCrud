package com.zca.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zca.domain.Course;
import com.zca.domain.SC;
import com.zca.dao.CourseDao;
import com.zca.dao.SCDao;
import com.zca.service.CourseService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Demo class
 *
 * @author zca
 * @date 2020/7/20
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Autowired
    private SCDao scDao;

    @Override
    public boolean save(Course course) {
        return  courseDao.insert(course)>0;
    }

    @Override
    public boolean update(Course course) {
        return courseDao.updateById(course)>0;
    }

    @Override
    public boolean delete(Integer id) {
        QueryWrapper<SC> qw=new QueryWrapper<>();
        QueryWrapper<Course> qw1=new QueryWrapper<>();
        qw.select("cid");
        qw1.select("cid");
        boolean flag=false;
        List<SC> l1=scDao.selectList(qw);
        List<Course> l2=courseDao.selectList(qw1);
        for(Course c:l2) {
            for (SC sc : l1) {
                if(id.equals(c.getCid())) {
                    if (!sc.getCid().equals(id)) {
                        courseDao.deleteById(id);
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    @Override
    public Course getById(Integer id) {
        return courseDao.selectById(id);
    }

    @Override
    public IPage<Course> getPage(int currentPage, int pageSize) {
        IPage<Course> page = new Page<Course>(currentPage,pageSize);
        courseDao.selectPage(page,null);
        return page;

    }

    @Override
    public IPage<Course> getPage(int currentPage, int pageSize, Course course) {
        LambdaQueryWrapper<Course> lqw =new LambdaQueryWrapper<Course>();

        lqw.like(Strings.isNotEmpty(course.getCourseName()),Course::getCourseName,course.getCourseName());
        IPage<Course> page = new Page<Course>(currentPage,pageSize);
        courseDao.selectPage(page,lqw);
        return page;
    }

    @Override
    public List<Course> getAll() {
        return courseDao.selectList(null);
    }
}
