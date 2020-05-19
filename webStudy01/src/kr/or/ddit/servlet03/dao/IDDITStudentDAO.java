package kr.or.ddit.servlet03.dao;

import java.util.List;

import kr.or.ddit.vo.DDITStudentVO;

public interface IDDITStudentDAO {

	int insertStudent(DDITStudentVO vo);

	List<DDITStudentVO> selectStudentList();
	
	DDITStudentVO selectStudent(String code);

}