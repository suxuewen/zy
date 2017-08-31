package com.zhiyou100.zy.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy.mapper.UserMapper;
import com.zhiyou100.zy.model.User;
import com.zhiyou100.zy.model.UserExample;
import com.zhiyou100.zy.service.UserService;
import com.zhiyou100.zy.web.utils.MailUtil;
import com.zhiyou100.zy.web.utils.Md5utils;
@Service
public class UserServiceimpl implements UserService {

	@Autowired
	UserMapper um;
	
	@Override
	public void rigist(User u) {
		u.setPassword(Md5utils.getMd5(u.getPassword()));
	      um.insert(u);
	}

	@Override
	public List<User> findUserByU(User u) {
		UserExample ue=new UserExample();
		ue.createCriteria().andPasswordEqualTo(Md5utils.getMd5(u.getPassword())).andEmailEqualTo(u.getEmail());
		return um.selectByExample(ue);
	}

	@Override
	public void updateUser(User u) {
		
	      um.updateByPrimaryKeySelective(u);
		
	}

	@Override
	public void updateUserPwd(User u2) {
		u2.setPassword(Md5utils.getMd5(u2.getPassword()));
		um.updateByPrimaryKeySelective(u2);
	}

	@Override
	public void sendemail(String email) throws Exception {

		 int random=(int) (Math.random() * 10000+1);
		 String string =Integer.toString(random);
		 System.out.println(string);
    	UserExample ue=new UserExample();
    	ue.createCriteria().andEmailEqualTo(email);
        List<User> list = um.selectByExample(ue);
        User user = list.get(0);
        user.setCaptcha(string);
        um.updateByPrimaryKeySelective(user);
		MailUtil.send(email, "验证码",string);
	}

	@Override
	public List<User> findUserByEmail(User u) {
		UserExample ue=new UserExample();
		
		ue.createCriteria().andEmailEqualTo(u.getEmail()).andCaptchaEqualTo(u.getCaptcha());
	      
		return  um.selectByExample(ue);
	}
	


}
