package com.zhiyou100.zy.service;

import java.util.List;

import com.zhiyou100.zy.model.Admin;

public interface AdminService {

	List<Admin> findAdmin(String username, String password);



	
	
}
