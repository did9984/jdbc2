package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi2")
public class Nana extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setCharacterEncoding("UTF-8"); // utf -8 로설정 
	     resp.setContentType("text/html; charset:UTF-8"); // 브라우저가 utf-8로 읽어들이게 설정  
		
		PrintWriter out = resp.getWriter(); // 자바에서 html 글을 나오게 하는 태그  
		
		String cnt_ =req.getParameter("cnt");
		
		int cnt =100; //cnt 의 값을 임시 지정 
		if (cnt_ != null && !cnt_.equals("")) { //만약 cnt 값이 없다면 100을 불러와서 주소창에 입력  
			cnt = Integer.parseInt(cnt_); // url 옆에 ? cnt =숫자 입력시 값 주기 가능 
		}
		  
		
		for (int i = 0; i<cnt; i++)
			out.println((i+1)+":안녕 servelet! <br>");
		
	}

}
