package com.zhiyou100.zy.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.zy.model.User;
import com.zhiyou100.zy.service.UserService;
import com.zhiyou100.zy.web.utils.MailUtil;

@Controller
public class UserController {
  @Autowired
  UserService us;
	

	@RequestMapping(value="/front/user/rigist.action",method=RequestMethod.POST)
	@ResponseBody
	public User rigist(User u){
	
		us.rigist(u);
		return u;
		
	}

	
	@RequestMapping(value="/front/user/login.action",method=RequestMethod.POST)
	@ResponseBody
	public User login(User u,HttpServletRequest req){	
	List<User> li=us.findUserByU(u);
	
	req.getSession().setAttribute("user", li.get(0));
	if(li.isEmpty()){
		return null;
	}{
		return u;
	}
	} 
	
	
	@RequestMapping("/front/forgetpwd.action")
	public String findpassword(){
		
		
		return "/front/user/forget_pwd";
	}
	
	@RequestMapping("/front/sendemail.action")
	@ResponseBody
	public User sendmail(String email) throws Exception{
		User u=new User();
		u.setEmail(email);
		us.sendemail(email);
		
		return u;
	}
	@RequestMapping("/front/forgetpwd1.action")
	public String resetpassword(String email,Model md,String captcha){
		md.addAttribute("email", email);
		md.addAttribute("captcha", captcha);
		return"/front/user/reset_pwd";
	}
	
	@RequestMapping("/front/resetpwd.action")
	public String reset(String email,String captcha,String password){
		User u=new User();
		
		u.setEmail(email);
		u.setCaptcha(captcha);
		List<User> li=us.findUserByEmail(u);
		User user = li.get(0);
		user.setCaptcha(captcha);
		user.setPassword(password);
	
		us.updateUserPwd(user);;
		return "forward:/index.jsp";
				
	}

	@RequestMapping("/front/user/index.action")
	public String user(HttpSession session){
	           
		return "/front/user/index";
		
	}
	
	@RequestMapping("/front/user/profile.action")
	public String userprofile(){
		
		
		return "/front/user/profile";
		
	}
	
	@RequestMapping(value="/front/user/profile1.action",method=RequestMethod.POST)
	public String update(User u,HttpServletRequest req){
	User u1 = (User) req.getSession().getAttribute("user");
	  u.setEmail(u1.getEmail());   
	  u.setId(u1.getId());
	  us.updateUser(u);
	  	
	  return "/front/user/index";
		
	}
	
	@RequestMapping("/front/user/avatar.action")
	public String pic(){
		
		return "/front/user/avatar";
	}
	
	@RequestMapping(value="/front/user/avatar.action",method=RequestMethod.POST)
	public String picupload(MultipartFile image_file,HttpServletRequest req) throws IllegalStateException, IOException{
		 String str = UUID.randomUUID().toString().replaceAll("-", "");
		 String ext = FilenameUtils.getExtension(image_file.getOriginalFilename());
		 String fileName = str+"."+ext;
		 System.out.println(fileName);
		 String path = "D:\\upload";
		 image_file.transferTo(new File(path+"\\"+fileName));
		 
		 User u1 = (User) req.getSession().getAttribute("user");
		u1.setHeadUrl(fileName);
		us.updateUser(u1);
		 req.getSession().setAttribute("user", u1);
		return "/front/user/index";
	}
	
	@RequestMapping("/front/user/password.action")
	public  String pwd(){
		
		return "/front/user/password";
	}
	
	@RequestMapping("/front/user/password1.action")
	public  String pwdreset(HttpServletRequest req,String newPassword){
		 User u2 = (User) req.getSession().getAttribute("user");
		u2.setPassword(newPassword);
		us.updateUserPwd(u2);
		/*req.getSession().setAttribute("user", u2);*/
		req.getSession().removeAttribute("user");
		return "redirect:/index.jsp";
	}
	@RequestMapping("/front/user/logout.action")
	public String loginout(HttpServletRequest req){
		
		req.getSession().removeAttribute("user");
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/front/backtoindex.action")
	public String backtoindex(HttpServletRequest req){
		
		
		return "redirect:/index.jsp";
	}
	
	
	
	
	
	
	
}
