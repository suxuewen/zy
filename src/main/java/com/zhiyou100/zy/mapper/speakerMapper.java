package com.zhiyou100.zy.mapper;

import com.zhiyou100.zy.model.speaker;
import com.zhiyou100.zy.model.speakerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface speakerMapper {
    int countByExample(speakerExample example);

    int deleteByExample(speakerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(speaker record);

    int insertSelective(speaker record);

    List<speaker> selectByExample(speakerExample example);

    speaker selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") speaker record, @Param("example") speakerExample example);

    int updateByExample(@Param("record") speaker record, @Param("example") speakerExample example);

    int updateByPrimaryKeySelective(speaker record);

    int updateByPrimaryKey(speaker record);

	List<speaker> findspeakerByPage(@Param("page")Integer page,@Param("speakerJob") String speakerJob,@Param("speakerName")String speakerName);
}