package kr.or.ddit.servlet03;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.servlet03.dao.DDITStudentDAO;
import kr.or.ddit.servlet03.dao.IDDITStudentDAO;
import kr.or.ddit.vo.DDITStudentVO;

@WebServlet("/ddit/dditStudents.do")
public class DDITStudentReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	IDDITStudentDAO dao = DDITStudentDAO.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DDITStudentVO> allStudents = dao.selectStudentList();
		request.setAttribute("allStudents", allStudents);
		request.getRequestDispatcher("/WEB-INF/views/ddit/dditStudents.jsp").forward(request, response);
	}

}








