package com.zhiyou100.zy.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.zy.model.Admin;
import com.zhiyou100.zy.service.AdminService;

@Controller
public class AdminController {
	
	
	  @RequestMapping("/admin/login1.action")    
	 public String login1(){
		  return "/admin/login";
	  }
	
	
	
	
	
	
	
	
	
	
	
      @Autowired
	AdminService as;
	    @RequestMapping("/admin/login.action")    
      public String login(Admin ad,HttpServletRequest req,HttpSession session ){
	   	List<Admin> li= as.findAdmin(ad.getLoginName(),ad.getLoginPwd());
	   	String str=null;
	   
	    	if(li.isEmpty()==false ){
	    		str="forward:/admin/video/videolist.action";
	    		Admin admin = li.get(0);
	    		
	    		session.setAttribute("admin", admin);
	    		session.setAttribute("name", admin.getLoginName());
	    	}else{
	    		req.setAttribute("errorMessage","用户名或者密码错误");
	    		str="forward:/WEB-INF/admin/login.jsp";
	    	}  	
		return str;
    
      }	
}
