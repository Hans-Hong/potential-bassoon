package kr.or.ddit.commons.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enums.ServiceType;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index.do")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("command");
		if(StringUtils.isNoneBlank(param)) {
			try {
			String contentUrl = ServiceType.findContentUrl(param);
			request.setAttribute("includePage", contentUrl);
			}catch (Exception e) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "그런 서비스 없다.");
				return;
			}
		}
		
		String goPage = "/WEB-INF/views/index.jsp";
		request.getRequestDispatcher(goPage).forward(request, response);
	}
}
