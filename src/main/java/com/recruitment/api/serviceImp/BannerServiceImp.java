package com.recruitment.api.serviceImp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.recruitment.api.config.DBConnPool;
import com.recruitment.api.entities.Banner;
import com.recruitment.api.helpers.MappingHelper;
import com.recruitment.api.service.BannerService;
import com.recruitment.api.helpers.Extensions;

import oracle.jdbc.OracleTypes;

@Service
public class BannerServiceImp implements BannerService{
	
	@Override
	public Banner GetBanner(int bannerID) {
		Banner response = new Banner();
		try (Connection conn =  DBConnPool.getConnection()) {
			try (CallableStatement pStmt = conn.prepareCall("{call HRTGDD.HR_BANNER_SEL(?,?)}")) {
				pStmt.registerOutParameter(1, OracleTypes.CURSOR);
				pStmt.setInt(2, bannerID);
				pStmt.execute();
				ResultSet resultSet = (ResultSet) pStmt.getObject(1);
				while (resultSet.next()) {						
					ModelMapper modelMapper = new ModelMapper();
					response = modelMapper.map(MappingHelper.MappingResultSetToObject(resultSet),Banner.class);
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
	public int DeleteBanner(int bannerID)
    {
		int result = 0;
		try (Connection conn =  DBConnPool.getConnection()) {
			try (CallableStatement pStmt = conn.prepareCall("{call HRTGDD.HR_BANNER_DEL(?,?,?)}")) {
				pStmt.registerOutParameter(1, Types.INTEGER);
				pStmt.setInt(2, bannerID);
				pStmt.setString(3, "Admin");
				result = pStmt.executeUpdate();
				if(result > 0)
				{
					//
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
		return result;
    }
	
	@Override
	public Banner AddBanner(Banner banner)
    {
		int result = 0;
        try (Connection conn =  DBConnPool.getConnection()) {
			try (CallableStatement pStmt = conn.prepareCall("{call HRTGDD.HR_BANNER_ADD(?,?,?,?,?,?,?,?,?,?,?,?)}")) {
				pStmt.registerOutParameter(1, Types.INTEGER);
				pStmt.setString(2, banner.getBannerName());
				pStmt.setString(3, banner.getImage());
				pStmt.setString(4, banner.getUrl());
				pStmt.setString(5, banner.getDescription());
				pStmt.setDate(6, Extensions.convertUtilToSql(banner.getStartDate()));
				pStmt.setDate(7, Extensions.convertUtilToSql(banner.getEndDate()));
				pStmt.setInt(8, banner.getPosition());
				pStmt.setInt(9, banner.isIsActived() ? 1 : 0);
				pStmt.setString(10, "Admin");
				pStmt.setString(11, "Admin");
				pStmt.setInt(12, banner.getDisplayOrder());
				result = pStmt.executeUpdate();					
				if(result > 0)					
					banner  = GetBanner(banner.getBannerID());
				}							
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return result > 0 ? banner : null;
    }
	
	@Override
	public Banner UpdateBanner(Banner banner)
    {
		int result = 0;
        try (Connection conn =  DBConnPool.getConnection()) {
			try (CallableStatement pStmt = conn.prepareCall("{call HRTGDD.HR_BANNER_UPD(?,?,?,?,?,?,?,?,?,?,?,?,?)}")) {
				pStmt.registerOutParameter(1, Types.INTEGER);
				pStmt.setInt(2, banner.getBannerID());
				pStmt.setString(3, banner.getBannerName());
				pStmt.setString(4, banner.getImage());
				pStmt.setString(5, banner.getUrl());
				pStmt.setString(6, banner.getDescription());
				pStmt.setDate(7, Extensions.convertUtilToSql(banner.getStartDate()));
				pStmt.setDate(8, Extensions.convertUtilToSql(banner.getEndDate()));
				pStmt.setInt(9, banner.getPosition());
				pStmt.setInt(10, banner.isIsActived() ? 1 : 0);
				pStmt.setString(11, "Admin");
				pStmt.setString(12, "Admin");
				pStmt.setInt(13, banner.getDisplayOrder());
				result = pStmt.executeUpdate();		
				if(result > 0)					
					banner  = GetBanner(banner.getBannerID());
				}			
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return result > 0 ? banner : null;
    }
}
