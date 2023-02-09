package com.newlecture.web;

import java.awt.Button;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.sun.net.httpserver.Authenticator.Result;

import jdk.jfr.ContentType;
 

@WebServlet("/Calc2") // 연결할 url
public class Calc2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setCharacterEncoding("UTF-8"); // utf -8 로설정
		res.setContentType("text/html; charset:UTF-8"); // 브라우저가 utf-8로 읽어들이게 설정
		// req.setCharacterEncoding("UTF-8"); // 서버에 내용을 보낼때 한글로 입력되게 설정

		PrintWriter out = res.getWriter(); // 자바에서 html 글을 나오게 하는 태그
		ServletContext application = req.getServletContext();
		String content = req.getParameter("v"); //name v 인 태그를 가져옴 
		String op = req.getParameter("button"); // name button 인 태그를 가져옴 
		int v = 0; 
		if(!content.equals("")) v = Integer.parseInt(content);
		
		if(op.equals("=")) {
			
			int x = (Integer)application.getAttribute("value"); //value 에 값들을 int 로 바꾼다 
			int y = v;
			String operator = (String)application.getAttribute("op"); 
			 
			int result = 0;
			 
			 if (operator.equals("+")) 
				result = x+y;
			else 
				result = x-y;
			
			res.getWriter().printf("result is %d\n", result);
		}
		else {
			application.setAttribute("value",v);
			application.setAttribute("op",op);
			
		} 
		

	}
}
