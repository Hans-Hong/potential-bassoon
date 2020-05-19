package kr.or.ddit.commons.dao;

import kr.or.ddit.vo.MemberVO;

/**
 * 인증 처리에 사용할 Persistence Layer
 *
 */
public interface IAuthenticateDAO {
	/**
	 * 식별자를 이용한 회원 정보 조회
	 * @param member TODO
	 * @return 존재한다면, VO 객체 반환, 존재하지 않는다면, null 반환
	 */
	public MemberVO selectMember(MemberVO member);
}
