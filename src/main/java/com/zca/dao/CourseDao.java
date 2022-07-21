package com.zca.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zca.domain.Course;
import org.apache.ibatis.annotations.Mapper;
/**
 * Demo class
 *
 * @author zca
 * @date 2020/7/20
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Mapper
public interface CourseDao extends BaseMapper<Course> {

}
