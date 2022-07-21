package com.zca.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zca.domain.SC;
import com.zca.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 * Demo class
 *
 * @author zca
 * @date 2020/7/20
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Mapper
public interface StudentDao extends BaseMapper<Student> {
    /**通过学生id查询所有的关联信息
     *
     * @param  id 学生id
     * @return Result<学生信息>
     */
    @Select("select distinct lession.student.sid , lession.student.stud_name, lession.student.sex, lession.student.grade,lession.course.cid,lession.course.course_name,lession.course.credit " +
            "from lession.student,lession.course,lession.sc " +
            "where course.cid=sc.cid and student.sid=sc.sid and student.sid =#{id}")

    List<SC> getStudentCourseBySid(Integer id);
}
