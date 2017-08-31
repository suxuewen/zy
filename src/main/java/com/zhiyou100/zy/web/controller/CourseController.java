package com.zhiyou100.zy.web.controller;

import java.util.List;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.zy.model.Page;
import com.zhiyou100.zy.model.course;
import com.zhiyou100.zy.model.subject;
import com.zhiyou100.zy.service.CourseService;

@Controller
@RequestMapping("/admin")
public class CourseController {
@Autowired
CourseService cs;
	@RequestMapping("/course/courselist.action")
	public ModelAndView findAllCourse(@RequestParam(defaultValue="1") Integer page ){
		
		ModelAndView mav=new ModelAndView();
		
		Page<course> p1 =cs.findAllCourse(page);
		
		mav.setViewName("/course/courselist");
		
		mav.addObject("page",p1);
		
	
		return mav;
	}
	@RequestMapping("/course/addcourse.action")
	public String addcourse(Model md){
		List<subject> li=cs.findAddsubject();
		md.addAttribute("subjectlist",li);
		return "/course/addcourse";
		
	}
	@RequestMapping("/course/addcourse1.action")
	public String addcourse1(course c){
	
	    cs.addCourse(c);
		return "forward:/course/courselist.action";
		
	}
	
	
	
	
	@RequestMapping("/course/courseedit.action")
	public String editcourse(int id,Model md){
	
	   course c=cs.findCourseById(id);
	   List<subject> li=cs.findAddsubject();
		md.addAttribute("subjectlist",li);
		md.addAttribute("courselist",c);
		return "/course/courseedit";
		
	}
	

	@RequestMapping("/course/courseedit1.action")
	public String editcourse1(course c){
	      cs.updatecourse(c);
		
		
	   
		return "forward:/course/courselist.action";
		
	}
	
	@RequestMapping("/course/coursedelete.action")
	public String deletecourse(int  id){
	     
		cs.deleteCourse(id);
		
	   
		return "forward:/course/courselist.action";
		
	}
	@RequestMapping("/front/course/index.action")
	public String course(Model md,int subjectId){
	md.addAttribute("subjectId",subjectId);
	      subject  sub=cs.findSubjectById(subjectId);
	List<course> course = cs.findCourseAndVideo(subjectId);
	
	md.addAttribute("subject",sub);
	md.addAttribute("courses",course);
		return "/front/course/index";
	}
		
	
}
