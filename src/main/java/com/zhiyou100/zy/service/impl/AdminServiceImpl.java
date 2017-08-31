package com.zhiyou100.zy.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.zhiyou100.zy.mapper.AdminMapper;
import com.zhiyou100.zy.model.Admin;
import com.zhiyou100.zy.model.AdminExample;
import com.zhiyou100.zy.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
	AdminMapper adm;

	@Override
	public List<Admin> findAdmin(String username, String password) {
		
		AdminExample ae=new AdminExample();
		ae.createCriteria().andLoginNameEqualTo(username).andLoginPwdEqualTo(password);
		
		List<Admin> list = adm.selectByExample(ae);
		
		return list;
	}
	
	
}
