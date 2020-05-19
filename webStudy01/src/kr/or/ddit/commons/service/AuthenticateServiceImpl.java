package kr.or.ddit.commons.service;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.commons.dao.AuthenticateDAOImpl;
import kr.or.ddit.commons.dao.IAuthenticateDAO;
import kr.or.ddit.enums.ServiceResult;
import kr.or.ddit.vo.MemberVO;

public class AuthenticateServiceImpl implements IAuthenticateService {
	// 싱글턴
	// 의존관계 형성
	private AuthenticateServiceImpl() {}
	private static IAuthenticateService self = new AuthenticateServiceImpl();
	public static IAuthenticateService getInstance() {
		if(self==null) self = new AuthenticateServiceImpl();
		return self;
	}
	
	IAuthenticateDAO dao = AuthenticateDAOImpl.getInstance();
	
	@Override
	public ServiceResult authenticated(MemberVO member) {
		MemberVO savedMember = dao.selectMember(member);
		ServiceResult result = null;
		if(savedMember!=null) {
			try {
				BeanUtils.copyProperties(member, savedMember);
			} catch (IllegalAccessException | InvocationTargetException e) {
				throw new RuntimeException(e);
			}
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAIL;
		}
		return result;
	}

}
