package com.zhiyou100.zy.web.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CustomInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		  /*System.out.println("视图渲染显示后调�?,可查看日�?,清理�?些资�?");*/

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		 /*System.out.println("controller执行后调�?,参数是req和res,controller对象和数据视�?,"
		 		+ "可以对数据进行处�?");*/

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
		 String name=(String) req.getSession().getAttribute("name");
            if(name==null){
		
	     /* res.sendRedirect(req.getContextPath()+"/WEB-INF/view/admin/login.jsp");	*/
	      req.getRequestDispatcher("/WEB-INF/view/admin/login.jsp").forward(req, res);
			return false;
	
		}else{
			
			return true;
		
		}
		
		
		
		
}

}
