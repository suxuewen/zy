package com.zhiyou100.zy.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.zy.model.course;
import com.zhiyou100.zy.service.CourseService;
import com.zhiyou100.zy.service.VideoService;

@Controller
public class ChartsMapper {
	     @Autowired
         CourseService cs;
	     @Autowired
	     VideoService vs;
	     
	     
	
	@RequestMapping("/charts/chartslist.action")
	public String chartslist(Model md){
		
	  List<Integer> list2 = vs.findAvgPlayTimes();
	  
	  md.addAttribute("value", list2);
		List<course> list=cs.findCourse();
		String name1="";
		
	for (course c:list){
		String name = c.getCourseName();
		name1=name1+","+"'"+name+"'";
	}
	String string1="["+name1.substring(1, name1.length())+"]";
	
		md.addAttribute("data", string1);
		
		return "forward:/WEB-INF/view/charts/chartsList.jsp";
	}
	
	
}
