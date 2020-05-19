package kr.or.ddit.servlet03.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.DDITStudentVO;

public class DDITStudentDAO implements IDDITStudentDAO {
	private static Map<String, DDITStudentVO> tableMap;
	static {
		tableMap = new LinkedHashMap<>();
	}
	private static IDDITStudentDAO self = new DDITStudentDAO();
	private DDITStudentDAO() {}
	public static IDDITStudentDAO getInstance(){
		return self;
	}
	
	/* (non-Javadoc)
	 * @see kr.or.ddit.servlet03.dao.IDDITStudentDAO#insertStudent(kr.or.ddit.vo.DDITStudentVO)
	 */
	@Override
	public int insertStudent(DDITStudentVO vo){
//		S001, S002...
		int recordCnt = tableMap.size();
		String code = String.format("S%03d", recordCnt+1);
		vo.setCode(code);
		tableMap.put(code, vo);
		return 1;
	}
	
	/* (non-Javadoc)
	 * @see kr.or.ddit.servlet03.dao.IDDITStudentDAO#selectStudentList()
	 */
	@Override
	public List<DDITStudentVO> selectStudentList() {
		return new ArrayList<DDITStudentVO>( tableMap.values() );
	}
	
	@Override
	public DDITStudentVO selectStudent(String code) {
	
		return null;
	}
}














