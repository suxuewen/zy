package com.zhiyou100.zy.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.zy.model.Page;
import com.zhiyou100.zy.model.speaker;
import com.zhiyou100.zy.service.SpeakerService;

@Controller
public class SpeakerController {

	  @Autowired
	SpeakerService ss;
	
	  @RequestMapping("/speaker/speakerlist.action")   
	 public ModelAndView findAllSpeaker(@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="")String speakerName
			 ,@RequestParam(defaultValue="")String speakerJob){
		/* List<speaker> li=ss.findAllSpeaker();*/
		 Page<speaker> page2 = ss.findSpeakerByPage(page,speakerJob,speakerName);
		 
		 ModelAndView mav=new ModelAndView();
		 mav.addObject("page",page2);
		 mav.setViewName("/speaker/speakerlist");
		 mav.addObject("speakerName",speakerName);
		 mav.addObject("speakerJob",speakerJob);
		 return mav ;
	 }
	  
	  
	  
	  
	  
	  @RequestMapping("/speaker/addspeaker.action")   
		 public String addSpeaker(){
		 return "/speaker/addspeaker";
				 
		
		 }
	  
	  
	  
	  @RequestMapping("/speaker/addspeaker1.action")   
		 public String addSpeaker1(speaker sp){
		 
		  ss.insertspeaker(sp);	 
		  
	return "redirect:/speaker/speakerlist.action";
		 }
	  

	  @RequestMapping("/speaker/speakeredit.action")   
		 public String Speakeredit(int id,Model md){
		 
		 speaker s1=ss.speakerById(id);
		  md.addAttribute("s1",s1);
		   
		  
	return "/speaker/speakeredit";
		 }
	  
	  @RequestMapping("/speaker/speakeredit1.action")   
		 public String Speakeredit1(speaker sp){
		 System.out.println(sp);
		 ss.updatespeaker(sp);
		
		   
		  
		 return "redirect:/speaker/speakerlist.action";
		 }
	  @RequestMapping("/speaker/speakerdelete.action")
	  public String speakerdelete(int id){
		  ss.deletespeaker(id);
		  
		  
		  
		  return "redirect:/speaker/speakerlist.action";  
	  }
	  
	  
}
