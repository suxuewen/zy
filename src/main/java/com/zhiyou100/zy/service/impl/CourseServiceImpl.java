package com.zhiyou100.zy.service.impl;

import java.util.List;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy.mapper.courseMapper;
import com.zhiyou100.zy.mapper.subjectMapper;
import com.zhiyou100.zy.model.Page;
import com.zhiyou100.zy.model.course;
import com.zhiyou100.zy.model.subject;
import com.zhiyou100.zy.model.video;
import com.zhiyou100.zy.service.CourseService;
import com.zhiyou100.zy.web.utils.VideoLength;
@Service
public class CourseServiceImpl implements CourseService {
         
	@Autowired
	courseMapper cm;
	@Autowired
subjectMapper sm;
	
	
	@Override
	public Page<course> findAllCourse(Integer page) {
		Page<course> p1 =new Page<>();
		int p2=(page-1)*10;
		List<course> li= cm.findAllCourse(p2);
		p1.setSize(10);
		p1.setTotal(cm.countByExample(null));
		p1.setPage(page);
		p1.setRows(li);
		
		return p1;
	}

	@Override
	public List<subject> findAddsubject() {
		
		return sm.selectByExample(null);
	}

	@Override
	public void addCourse(course c) {
		cm.insert(c);
		
	}

	@Override
	public course findCourseById(int id) {
		
		return cm.selectByPrimaryKey(id);
	}

	@Override
	public void updatecourse(course c) {
		cm.updateByPrimaryKey(c);
		
	}

	@Override
	public void deleteCourse(int id) {
		cm.deleteByPrimaryKey(id);
		
	}

	@Override
	public List<course> findCourse() {
		
		return cm.selectByExample(null);
	}

	@Override
	public subject findSubjectById(int subjectId) {
		 
		return sm.selectByPrimaryKey(subjectId);
	}

	@Override
	public List<course> findCourseAndVideo(int subjectId) {
		List<course> list = cm.findCourseAndVideo(subjectId);
		for(course c:list){
			
			List<video> list2 = c.getVid();
			for(video v:list2){
				Integer length = v.getVideoLength();
		String string = VideoLength.main(length);
	v.setVideoLengthStr(string);
	}
		}	
		return cm.findCourseAndVideo(subjectId);
	
}
}