package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.Authenticator.Result;
@WebServlet("/Calc") // 연결할 url 
public class Calc extends HttpServlet {
  
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("UTF-8"); // utf -8 로설정
		res.setContentType("text/html; charset:UTF-8"); // 브라우저가 utf-8로 읽어들이게 설정
       // req.setCharacterEncoding("UTF-8"); // 서버에 내용을 보낼때 한글로 입력되게 설정  
		
		
		PrintWriter out = res.getWriter(); // 자바에서 html 글을 나오게 하는 태그

		int title = Integer.parseInt(req.getParameter("one")); // getparameter 가 string 으로 인식하니 parseint 로 묶어줌 
		int content = Integer.parseInt(req.getParameter("two"));
        String op = req.getParameter("button");
	    int result = 0;
        
        if(op.equals("add")) {
			result = title+content;
		}else {
			result = title-content;
		}
        
		out.printf("result: %d",result); // 1,2 합  
		
	}
}
