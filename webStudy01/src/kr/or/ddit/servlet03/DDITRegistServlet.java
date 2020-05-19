package kr.or.ddit.servlet03;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.servlet03.dao.DDITStudentDAO;
import kr.or.ddit.servlet03.dao.IDDITStudentDAO;
import kr.or.ddit.vo.DDITStudentVO;


@WebServlet("/ddit/regist.do")
public class DDITRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private void attibuteSetting(HttpServletRequest req){
		Map<String, String> gradeMap = new LinkedHashMap<>();
		Map<String, String> licenseMap = new LinkedHashMap<>();
		req.setAttribute("gradeMap", gradeMap);
		req.setAttribute("licenseMap", licenseMap);
		gradeMap.put("G001", "고졸");
		gradeMap.put("G002", "대재");
		gradeMap.put("G003", "초대졸");
		gradeMap.put("G004", "대졸");
		gradeMap.put("G005", "석사");
		gradeMap.put("G006", "박사");
		licenseMap.put("L001", "정보처리기사");
		licenseMap.put("L002", "정보보안기사");
		licenseMap.put("L003", "SQLD");
		licenseMap.put("L004", "SQLP");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		attibuteSetting(request);
		request.getRequestDispatcher("/WEB-INF/views/ddit/registForm.jsp").forward(request, response);
	}

	IDDITStudentDAO dao = DDITStudentDAO.getInstance(); // has a 관계, 의존관계
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		attibuteSetting(req);
		//		1. 디코딩 설정
		req.setCharacterEncoding("UTF-8");
//		2. 파라미터 확보 (VO)
		DDITStudentVO vo = new DDITStudentVO();
		req.setAttribute("newStudent", vo);
//		vo.setName(req.getParameter("name"));
//		vo.setCareer(req.getParameter("career"));
//		vo.setGen(req.getParameter("gen"));
		Map<String, String[]> parameterMap = req.getParameterMap();
		try {
			BeanUtils.populate(vo, parameterMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
			return;
		}
		
//		Iterator<String> pNames = parameterMap.keySet().iterator();
//		while (pNames.hasNext()) {
//			String paramName = (String) pNames.next();
//			try {
//				Field field = DDITStudentVO.class.getDeclaredField(paramName);
//				field.setAccessible(true);
//				field.set(vo, req.getParameter(paramName));
//			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
//				continue;
//			}
//		}
		System.out.println(vo);
//		3. 검증 : 이름, 생일, 나이, 성별
		Map<String, String> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		boolean valid = validate(vo, errors);
		String goPage = null;
		boolean redirect = false;
		if(valid) {
//		4-1. 검증 통과
//			저장
			int cnt = dao.insertStudent(vo);
			// 성공 : /ddit/dditStudents.do(Model2) ,  Redirect -> Get (PRG)
			goPage = "/ddit/dditStudents.do";
			redirect = true;
			HttpSession session = req.getSession();
			session.setAttribute("lastStudent", vo);
		}else {
//		4-2. 불통
			// 실패 : 필수 파라미터 누락, 기존 입력 데이터, 메시지
//			registForm 이동( VO, message  공유)
			// scope 를 통해 데이터를 공유.
			goPage = "/WEB-INF/views/ddit/registForm.jsp";
		}
		
		if(redirect) {
			resp.sendRedirect(req.getContextPath() + goPage);
		}else {
			req.getRequestDispatcher(goPage).forward(req, resp);
		}
		
	}

	private boolean validate(DDITStudentVO vo, Map<String, String> errors) {
		boolean valid = true;
		if(StringUtils.isBlank(vo.getName())) {
			valid = false;
			errors.put("name", "이름 누락");
		}
		if(vo.getAge() > 40) {
			valid = false;
			errors.put("age", "연령 제한");
		}
		if(StringUtils.isBlank(vo.getGen()) || !vo.getGen().matches("[FM]")) {
			valid = false;
			errors.put("gen", "성별 확인");
		}
		if(StringUtils.isNotBlank(vo.getBirthday())) {
			// 2020-05-13
			try {
				new SimpleDateFormat("yyyy-MM-dd").parse(vo.getBirthday());
			} catch (ParseException e) {
				valid = false;
				errors.put("birthday", "생일 형식 확인");
			}
		}
		return valid;
	}
}
















