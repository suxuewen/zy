package com.zhiyou100.zy.service;

import java.util.List;

import com.zhiyou100.zy.model.Page;
import com.zhiyou100.zy.model.course;
import com.zhiyou100.zy.model.speaker;
import com.zhiyou100.zy.model.subject;
import com.zhiyou100.zy.model.video;

public interface VideoService {

	


	Page<video> findAllVideo(String videoSearchField, String videoSpeaker, String videoCourse, Integer page);
	List<course> findAllCourse();
	List<speaker>findAllSpeaker();
	void addvideo(video v);
	video findVideoById(int id);
	void updateVideo(video v);
	void deletevideo(int id);
	void deletevideos(Integer[] ids);
	 List<Integer> findAvgPlayTimes();
	subject findSubjectName(int subjectId);
	List<video> findSpeakerAndCourse(int videoId);
	List<video> findVideoList(int videoId); 
}
