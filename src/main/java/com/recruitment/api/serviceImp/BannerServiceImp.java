package com.recruitment.api.serviceImp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.recruitment.api.config.DBConnPool;
import com.recruitment.api.entities.Banner;
import com.recruitment.api.helpers.MappingHelper;
import com.recruitment.api.service.BannerService;

import oracle.jdbc.OracleTypes;

@Service
public class BannerServiceImp implements BannerService{
	
	@Override
	public List<Banner> GetBannerList(String keyword, int position, int currentPage, int recordPerpage) {
		List<Banner> response = new ArrayList<Banner>();
		
		try (Connection conn =  DBConnPool.getConnection()) {
			try (CallableStatement pStmt = conn.prepareCall("{call HRTGDD.HR_BANNER_SRH(?,?,?,?,?)}")) {
				pStmt.registerOutParameter(1, OracleTypes.CURSOR);
				pStmt.setString(2, keyword);
				pStmt.setInt(3, position);
				pStmt.setInt(4, currentPage);
				pStmt.setInt(5, recordPerpage);
				pStmt.execute();
				ResultSet resultSet = (ResultSet) pStmt.getObject(1);
				while (resultSet.next()) {						
//					ResultSetMetaData rsmd = resultSet.getMetaData();
//					int columnsCount = rsmd.getColumnCount();
//					Map<String, Object> params = new HashMap<String, Object>();
//					for (int i = 1; i < columnsCount + 1; i++) {
//
//						String cl = rsmd.getColumnName(i).toLowerCase();
//						int sqlType = rsmd.getColumnType(i);
//
//						if (resultSet.getObject(i) != null) {
//							switch (sqlType) {
//							case Types.BIGINT:
//							case Types.INTEGER:
//							case Types.TINYINT:
//							case Types.SMALLINT:
//
//								params.put(cl, resultSet.getInt(i));
//
//								break;
//							case Types.DATE:
//
//								params.put(cl, resultSet.getDate(i));
//
//								break;
//							case Types.TIMESTAMP:
//								params.put(cl, resultSet.getTimestamp(i).getTime());
//
//								break;
//							case Types.DOUBLE:
//								params.put(cl, resultSet.getDouble(i));
//
//								break;
//							case Types.FLOAT:
//								params.put(cl, resultSet.getFloat(i));
//
//								break;
//							case Types.NVARCHAR:
//								params.put(cl, resultSet.getString(i).trim());
//								break;
//							case Types.VARCHAR:
//								params.put(cl, resultSet.getString(i).trim());
//
//								break;
//							case Types.BLOB:
//								params.put(cl, resultSet.getBlob(i));
//
//								break;
//							case Types.CLOB:
//								params.put(cl, resultSet.getClob(i));
//
//								break;
//							case Types.NCLOB:
//								params.put(cl, resultSet.getNClob(i));
//								break;
//							default:
//								params.put(cl, resultSet.getString(i));
//
//								break;
//							}
//						} else {
//
//							params.put(cl, null);
//						}
//
//					}
//					
					ModelMapper modelMapper = new ModelMapper();
					Banner banner = modelMapper.map(MappingHelper.MappingResultSetToObject(resultSet),Banner.class);
					response.add(banner);
				}
				
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Banner GetBanner(int bannerID) {
		// TODO Auto-generated method stub
		return null;
	}

}
