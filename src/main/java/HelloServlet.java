
// HTTPServlet을 상속 받는다
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		응답 포맷 결정
//		text/html -> MIME Type
		resp.setContentType("text/html; charset=UTF-8");
//		name 파라미터를 받음
		String name = req.getParameter("name");
		
		if(name == null) {
			name = "Anonymous";  
		}
//		환영 메시지 출력
//		super.doGet(req, resp);
		PrintWriter out = resp.getWriter();
		out.println("<h1>Hello Servlet </h1>");
		out.printf("<p>Welcome, %s님</p", name);
	}
	/**
	 * @Author : 202-12
	 * @Date   : 2025. 1. 6.
	 */

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ContentType 설정
		resp.setContentType("text/html; charset=UTF-8");
		
//		POST 메서드 요청 처리
//		클라이언트로부터 전송된 모든 데이터를 루프 돌면서 출력
		PrintWriter out = resp.getWriter();
		out.println("<h1>폼 데이터 처리 </h1>");
		
		out.println("<p>폼으로부터 전송된 데이터</p>");
		Enumeration<String> params =  req.getParameterNames();
		
		out.println("<ul>");
		while (params.hasMoreElements()) {			
			String paramName = params.nextElement();	//	파라미터이름
			String paramValue = req.getParameter(paramName);
			
			out.printf("<li>%s=%s</li>", paramName, paramValue);
		}
//		super.doPost(req, resp);
		out.println("</ul>");
	}
	
	
}
