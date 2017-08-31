package com.zhiyou100.zy.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.zy.model.Page;
import com.zhiyou100.zy.model.course;
import com.zhiyou100.zy.model.speaker;
import com.zhiyou100.zy.model.subject;
import com.zhiyou100.zy.model.video;
import com.zhiyou100.zy.service.VideoService;

@Controller
@RequestMapping("/admin")
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
	@ResponseBody
	 public String videodelete(int id){
		System.out.println(id);
		vs.deletevideo(id);
		
		
		 return "success";
	 }
	
	@RequestMapping("/video/deletevideos.action")
	 public String deletevideos(Integer[] ids){
	
		vs.deletevideos(ids);
		return "redirect:/video/videolist.action";
	 }
	
	@RequestMapping("/front/video/index.action")
	public String videos( int videoId,int subjectId,Model md){
	md.addAttribute("videoId",videoId);	
	md.addAttribute("subjectId",subjectId);
	subject sub=vs.findSubjectName(subjectId);
	md.addAttribute("subject", sub);
		return "/front/video/index";
	 }
	
	@RequestMapping("/front/video/videoData.action")
	public String content(int videoId,Model md){
		List<video> li=vs.findSpeakerAndCourse(videoId);
		List<video> li1= vs.findVideoList(videoId);
		
		md.addAttribute("videoList", li1);
		md.addAttribute("video", li.get(0));
		return "/front/video/content";
		
	}
	
	
	
	
}
