
// HTTPServlet을 상속 받는다
import java.io.IOException;
import java.io.PrintWriter;

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
	
	
}
