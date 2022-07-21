package com.zca.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zca.domain.Course;
import com.zca.domain.SC;
import com.zca.domain.Student;
import com.zca.dao.CourseDao;
import com.zca.dao.SCDao;
import com.zca.dao.StudentDao;
import com.zca.service.StudentService;
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
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private SCDao scDao;

    @Autowired
    private CourseDao courseDao;

    @Override
    public boolean save(Student student) {
        return studentDao.insert(student)>0;
    }

    @Override
    public boolean update(Student student) {
        return studentDao.updateById(student)>0;
    }

    @Override
    public boolean delete(Integer id) {
        QueryWrapper<SC> qw=new QueryWrapper<>();
        qw.eq("sid",id);
        return scDao.delete(qw)>0 && studentDao.deleteById(id)>0;
    }

    @Override
    public Student getById(Integer id) {
        return studentDao.selectById(id);
    }

    @Override
    public List<SC> getStudentCourseBySid(Integer id) {

        return studentDao.getStudentCourseBySid(id);
    }

    @Override
    public boolean saveStudentCourse(Integer sid, Integer cid) {
        QueryWrapper<Course> qw=new QueryWrapper<>();
        qw.select("cid");
        boolean flag=false;
        List<Course> l1=courseDao.selectList(qw);
        for(Course d:l1) {
            if (cid.equals(d.getCid()))
            {
            scDao.saveStudentCourse(sid, cid);
            flag=true;
            }
        }

        return flag;
    }

    @Override
    public IPage<Student> getPage(int currentPage, int pageSize) {
        IPage<Student> page = new Page<Student>(currentPage,pageSize);
        studentDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Student> getPage(int currentPage, int pageSize, Student student) {
        LambdaQueryWrapper<Student>  lqw =new LambdaQueryWrapper<Student>();

        lqw.like(Strings.isNotEmpty(student.getStudName()),Student::getStudName,student.getStudName())
            .eq(student.getSex()!=null,Student::getSex,student.getSex())
            .eq(student.getGrade()!=null,Student::getGrade,student.getGrade());
        IPage<Student> page = new Page<Student>(currentPage,pageSize);
        studentDao.selectPage(page,lqw);
        return page;
    }


    @Override
    public List<Student> getAll() {
        return studentDao.selectList(null);
    }
}
