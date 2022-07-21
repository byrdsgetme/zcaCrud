package com.zca.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zca.domain.SC;
import com.zca.domain.Student;

import java.util.List;
/**
 * Demo class
 *
 * @author zca
 * @date 2020/7/20
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public interface StudentService{

    /**
     *通过学生id插入学生信息
     *
     * @param  student 学生信息
     * @return Result<boolean>
     */
    boolean save(Student student);


    /**
     *通过学生id更新学生信息
     *
     * @param  student 学生信息
     * @return Result<boolean>
     */
    boolean update(Student student);


    /**
     *通过学生id删除学生信息
     *
     * @param  id 学生id
     * @return Result<boolean>
     */
    boolean delete(Integer id);


    /**
     * 通过学生id查询学生信息
     *
     * @param id 学生id
     * @return Result<Student>
     */
    Student getById(Integer id);


    /**
     *通过学生id查询关联课程信息
     *
     * @param  id 学生id
     * @return Result<List<SC>>
     */
    List<SC> getStudentCourseBySid(Integer id);


    /**
     *通过学生id 和课程id 关联课程
     *
     * @param   sid 学生id
     * @param   cid 课程id
     * @return Result<boolean>
     */
    boolean saveStudentCourse(Integer sid, Integer cid);


    /**
     *学生信息分页查询
     *
     * @param currentPage 页码
     * @param pageSize 页尺寸
     * @return Result<IPage<Student>>
     */
    IPage<Student> getPage(int currentPage, int pageSize);


    /**
     *通过学生信息分页查询学生表
     *
     * @param currentPage 页码
     * @param pageSize 页尺寸
     * @param student 学生信息
     * @return Result<IPage<Student>>
     */
    IPage<Student> getPage(int currentPage, int pageSize, Student student);


    /**
     *查询所有学生信息
     *
     * @param
     * @return Result<学生信息集合>
     */
    List<Student> getAll();

}
