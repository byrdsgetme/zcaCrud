package com.zca.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zca.domain.SC;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
/**
 * Demo class
 *
 * @author zca
 * @date 2020/7/20
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Mapper
public interface SCDao extends BaseMapper<SC> {
    /**
     * 关联学生和课程
     *
     * @param sid 学生id
     * @param cid 课程id
     * @return Result<XxxxDO>
     */
    @Insert("insert into lession.sc(sid, cid) VALUE(#{sid},#{cid})")
    boolean saveStudentCourse(Integer sid, Integer cid);

}
