package com.zhiyou100.zy.service;

import java.util.List;

import com.zhiyou100.zy.model.User;

public interface UserService {

	void rigist(User u);

	List<User> findUserByU(User u);

	void updateUser(User u);

	void updateUserPwd(User u2);

	void sendemail(String email) throws Exception;

	List<User> findUserByEmail(User u);



}
