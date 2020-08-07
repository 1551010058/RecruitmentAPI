package com.recruitment.api.serviceImp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.recruitment.api.config.DBConnPool;
import com.recruitment.api.entities.Banner;
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
					Banner b = new Banner();
					b.setBannerID(resultSet.getInt("bannerID"));
					b.setImage(resultSet.getString("Image"));
					b.setBannerName(resultSet.getString("BannerName"));
					System.out.println(b);
					response.add(b);
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
