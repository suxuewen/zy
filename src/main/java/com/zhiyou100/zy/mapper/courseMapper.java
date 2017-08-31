package com.zhiyou100.zy.mapper;

import com.zhiyou100.zy.model.course;
import com.zhiyou100.zy.model.courseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface courseMapper {
    int countByExample(courseExample example);

    int deleteByExample(courseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(course record);

    int insertSelective(course record);

    List<course> selectByExample(courseExample example);

    course selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") course record, @Param("example") courseExample example);

    int updateByExample(@Param("record") course record, @Param("example") courseExample example);

    int updateByPrimaryKeySelective(course record);

    int updateByPrimaryKey(course record);

	List<course> findAllCourse(@Param("page")int p2);

	List<course> findCourseAndVideo(@Param("v")int subjectId);

	
}