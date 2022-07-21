package com.zca.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zca.domain.Course;

import java.util.List;
/**
 * Demo class
 *
 * @author zca
 * @date 2020/7/20
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public interface CourseService {


    /**
     *insert  data by course cid
     *
     * @param  course 课程信息
     * @return Result<boolean>
     */
    boolean save(Course course);


    /**
     *update data by course id
     *
     * @param  course 课程信息
     * @return Result<boolean>
     */
    boolean update(Course course);


    /**
     * delete data by course id
     *
     * @param  id 课程id
     * @return Result<boolean>
     */
    boolean delete(Integer id);


    /**
     *fetch data of student and course related to student by course id
     *
     * @param  id 课程id
     * @return Result<课程信息>
     */
    Course getById(Integer id);


    /**
     *分页查询
     *
     * @param  currentPage page number
     * @param  pageSize page size
     * @return Result<page>
     */
    IPage<Course> getPage(int currentPage, int pageSize);
    /**
     *通过课程信息分页查询
     *
     * @param  currentPage page number
     * @param  pageSize page size
     * @param  course 课程信息
     * @return Result<page>
     */
    IPage<Course> getPage(int currentPage, int pageSize, Course course);
    /**
     *查询所有课程的信息
     *
     * @return Result<List<Course></>>
     */
    List<Course> getAll();
}
