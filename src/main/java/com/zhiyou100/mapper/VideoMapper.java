package com.zhiyou100.mapper;

import com.zhiyou100.model.Course;
import com.zhiyou100.model.Speaker;
import com.zhiyou100.model.Video;
import com.zhiyou100.model.VideoExample;
import com.zhiyou100.model.VideoRemote;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoMapper {
    int countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    List<Video> selectByExample(VideoExample example);

    Video selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

	int findVideoCount(VideoRemote vr);

	List<Video> loadPage(VideoRemote vr);

	List<Speaker> findSpeaker();

	List<Course> findCourse();

	List<Video> selectAll();

	List<Video> selectVideoAndCourse();

	

	
}