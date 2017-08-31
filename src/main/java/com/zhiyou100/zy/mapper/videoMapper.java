package com.zhiyou100.zy.mapper;

import com.zhiyou100.zy.model.video;
import com.zhiyou100.zy.model.videoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface videoMapper {
    int countByExample(videoExample example);

    int deleteByExample(videoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(video record);

    int insertSelective(video record);

    List<video> selectByExample(videoExample example);

    video selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") video record, @Param("example") videoExample example);

    int updateByExample(@Param("record") video record, @Param("example") videoExample example);

    int updateByPrimaryKeySelective(video record);

    int updateByPrimaryKey(video record);
    int CountAllVideo(@Param("videoSearchField")String videoSearchField,@Param("videoSpeaker") String videoSpeaker, @Param("videoCourse")String videoCourse);
                  
    List<video> findAllVideo(@Param("videoSearchField")String videoSearchField,@Param("videoSpeaker") String videoSpeaker, @Param("videoCourse")String videoCourse, @Param("startpage")Integer startpage);

	void deleteVideos(@Param("ids")int[] ids);

	List<Integer> findAvgPlayTimes();

	List<video> findSpeakerAndCourse(@Param("id")Integer videoId);

	int findVideoList(@Param("id")int videoId);

	int findSubjectId(@Param("id")int id);

	List<video> findVideoBySubjectId(@Param("id")int subjectid);

	
}