package kr.or.ddit.servlet06.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.vo.DataBasePropertyVO;

public class DataBasePropertyDAOImpl implements IDataBasePropertyDAO {

	@Override
	public List<DataBasePropertyVO> selectDataBaseProperties(Map<String, Object> modelMap) {
		try(
				Connection conn = ConnectionFactory.getConnection();
				Statement stmt = conn.createStatement();	//4
			){
				String sql = "select property_name, property_value, description from database_properties";
				ResultSet rs = stmt.executeQuery(sql);
				ResultSetMetaData rsmd = rs.getMetaData();
				int count = rsmd.getColumnCount();
				String[] headers = new String[count];
				modelMap.put("headers", headers);
				for(int i= 1; i<=count; i++){
					headers[i-1] = rsmd.getColumnName(i);
				}
				List<DataBasePropertyVO> propList = new ArrayList<>();
				modelMap.put("propList", propList);
				while(rs.next()){
					DataBasePropertyVO vo = new DataBasePropertyVO();
					propList.add(vo);
					vo.setProperty_name(rs.getString("property_name"));
					vo.setProperty_value(rs.getString(2));
					vo.setDescription(rs.getString("description"));
				}
				return propList;
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
		
	}

}
