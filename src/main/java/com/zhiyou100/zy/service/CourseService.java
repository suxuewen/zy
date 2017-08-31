package com.zhiyou100.zy.service;

import java.util.List;

import javax.security.auth.Subject;

import com.zhiyou100.zy.model.Page;
import com.zhiyou100.zy.model.course;
import com.zhiyou100.zy.model.subject;

public interface CourseService {

	Page<course> findAllCourse(Integer page);

	List<subject> findAddsubject();

	void addCourse(course c);

	course findCourseById(int id);

	void updatecourse(course c);

	void deleteCourse(int id);

	List<course> findCourse();

	subject findSubjectById(int subjectId);

	List<course> findCourseAndVideo(int subjectId);

	

	

}
