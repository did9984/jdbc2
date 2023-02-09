package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/add2") // 연결할 url 
public class add2 extends HttpServlet {
  
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("UTF-8"); // utf -8 로설정
		res.setContentType("text/html; charset:UTF-8"); // 브라우저가 utf-8로 읽어들이게 설정
       // req.setCharacterEncoding("UTF-8"); // 서버에 내용을 보낼때 한글로 입력되게 설정  
		
		
		PrintWriter out = res.getWriter(); // 자바에서 html 글을 나오게 하는 태그

		
		String[] num = req.getParameterValues("num"); // getParametersValues(name) 배열로 지정된name 값을 가져와준다 
	  int result =0;
	  for (int i = 0; i < num.length; i++) {
		int num_ = Integer.parseInt(num[i]);
		result += num_;
	}
     out.print(result);
		 // 1,2 합 
		
	}
}
