package com.zhiyou100.zy.web.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomException implements HandlerExceptionResolver {
	/*
	 * 当三层某�?层发生了异常,就会被全�?异常处理
	 * 三个参数分别�?  请求  响应   发生异常的对�?  异常对象
	 * 返回值类型是ModelAndView,我们可以进行异常界面的跳�?
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse res, Object obj,
			Exception exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("obj", obj);
		mav.addObject("exception", exception);
		mav.setViewName("role/error");
		return mav;
	}

}
