//package com.ems.web.interceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//@Component
//public class RequestInterceptor extends HandlerInterceptorAdapter {
//
// 
// @Override
// public boolean preHandle(HttpServletRequest request, 
//		HttpServletResponse response, Object object) throws Exception {
//	/*System.out.println("In preHandle we are Intercepting the Request");
//	System.out.println("____________________________________________");
//	String requestURI = request.getRequestURI();
//	Integer personId = ServletRequestUtils.getIntParameter(request, "personId", 0);
//	System.out.println("RequestURI::" + requestURI + 
//			" || Search for Person with personId ::" + personId);
//	System.out.println("____________________________________________");
//	return true;*/
//	 
//	 Boolean isSuccess=false;
//
//		String url=request.getRequestURI();
//
//		try {
//
//			 String user=null;
//			HttpSession  session=request.getSession();
//
//			if(url.equalsIgnoreCase("/ems"))
//			{
//				isSuccess=true;
//				
//			}
//
//			else
//			{
//				if(null != session)
//				{
//					user = (String) session.getAttribute("logedUser");
//					if(null != user && !url.equals("/")){
//						isSuccess=true;
//					}else{
//					
//						response.sendRedirect("/ems");
//					}
//				}
//				else
//				{
//					
//					response.sendRedirect("/ems");
//					
//				}
//			}
//
//
//		} catch (Exception e) {
//
//			throw new Exception(e);
//		}
//
//		return isSuccess;
//	}
//
//
// /*@Override
// public void postHandle(HttpServletRequest request, HttpServletResponse response, 
//		Object object, ModelAndView model)
//		throws Exception {
//	System.out.println("_________________________________________");
//	System.out.println("In postHandle request processing "
//			+ "completed by @RestController");
//	System.out.println("_________________________________________");
// }
//
// @Override
// public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
//		Object object, Exception arg3)
//		throws Exception {
//	System.out.println("________________________________________");
//	System.out.println("In afterCompletion Request Completed");
//	System.out.println("________________________________________");
// }*/
// 
//}
