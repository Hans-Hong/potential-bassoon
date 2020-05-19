package kr.or.ddit.commons.dao;
	
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.vo.MemberVO;
	
public class AuthenticateDAOImpl implements IAuthenticateDAO {
	//싱글턴
	private AuthenticateDAOImpl() {}
	private static IAuthenticateDAO self = new AuthenticateDAOImpl();
	public static IAuthenticateDAO getInstance() {
		if(self==null) self = new AuthenticateDAOImpl();
		return self;
	}
	
	@Override
	public MemberVO selectMember(MemberVO member) {
		MemberVO savedMember = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" select mem_id, mem_pass, mem_name, mem_hp, mem_mail, mem_add1, mem_add2");
		sql.append(" from member                                                            ");
		sql.append(" where mem_id= ? and mem_pass = ?");
		System.out.println(sql);
		try(
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
		){
			stmt.setString(1, member.getMem_id());
			stmt.setString(2, member.getMem_pass());
			
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				savedMember = new MemberVO();
				savedMember.setMem_id(rs.getString("MEM_ID"));
				savedMember.setMem_pass(rs.getString("MEM_PASS"));
				savedMember.setMem_name(rs.getString("MEM_NAME"));
				savedMember.setMem_add1(rs.getString("MEM_ADD1"));
				savedMember.setMem_add2(rs.getString("MEM_ADD2"));
				savedMember.setMem_hp(rs.getString("MEM_HP"));
				savedMember.setMem_mail(rs.getString("MEM_MAIL"));
			}
			return savedMember;                                                                        
		}catch (SQLException e) {
		throw new RuntimeException(e);
		}

}
}
