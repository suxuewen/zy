package com.zhiyou100.zy.web.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.zy.model.Page;
import com.zhiyou100.zy.model.course;
import com.zhiyou100.zy.model.speaker;
import com.zhiyou100.zy.model.video;
import com.zhiyou100.zy.service.VideoService;

@Controller
public class VideoController {
    @Autowired
	VideoService vs;
	@RequestMapping("/video/videolist.action")
	public ModelAndView findAllVideo(@RequestParam(defaultValue="")String videoSpeaker,@RequestParam(defaultValue="")String videoCourse,@RequestParam(defaultValue="") String videoSearchField,@RequestParam(defaultValue="1") Integer page){
		
		Page<video> page1 = vs.findAllVideo(videoSearchField,videoSpeaker,videoCourse,page);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("page",page1);		
	     List<course> list = vs.findAllCourse();
	     List<speaker> list2 = vs.findAllSpeaker();
	 mav.addObject("course",list);
	 mav.addObject("speaker",list2);
	 mav.addObject("videoSearchField",videoSearchField);
	 mav.addObject("videoSpeaker",videoSpeaker);
	 mav.addObject("videoCourse",videoCourse);
	 mav.setViewName("/video/videolist");
	return mav;
	}
	
	
	
	
	
	@RequestMapping("/video/addvideo.action")
	           public ModelAndView addVideo(){
		ModelAndView mav=new ModelAndView();
		 List<course> list = vs.findAllCourse();
	     List<speaker> list2 = vs.findAllSpeaker();           	   
	     mav.addObject("course",list);
		 mav.addObject("speaker",list2);
		 mav.setViewName("/video/addvideo");
		 return mav;
		
	           }
	
	
	@RequestMapping("/video/addvideo1.action")
	 public String addvideo1(video v){
		 
		
		vs.addvideo(v);
		
		 
		 return "forward:/video/videolist.action";
	 }
	
	
	
	
	@RequestMapping("/video/videoedit.action")
	 public String videoedit(int id,Model md){
		video v=vs.findVideoById(id); 
		System.out.println(v);
		md.addAttribute("v",v);
		 List<course> list = vs.findAllCourse();
	     List<speaker> list2 = vs.findAllSpeaker(); 
		 md.addAttribute("course",list);
		 md.addAttribute("speaker",list2);
		 return "/video/videoedit";
	 }
	
	@RequestMapping("/video/videoedit1.action")
	 public String videoedit1(video v){
		System.out.println(v);
		vs.updateVideo(v);
		
		
		 return "forward:/video/videolist.action";
	 }
	
	
	
	
	@RequestMapping("/video/videodelete.action")
	 public String videodelete(int id){
		
		vs.deletevideo(id);
		
		
		 return "forward:/video/videolist.action";
	 }
	
	
	
	
	@RequestMapping("/video/deletevideos.action")
	 public String deletevideos(int[] ids){
		
		
		System.out.println(Arrays.toString(ids));
		vs.deletevideos(ids);
		
		
		 return "redirect:/video/videolist.action";
	 }
	
	
	
	
	
}
