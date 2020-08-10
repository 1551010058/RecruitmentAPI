package com.recruitment.api.helpers;

public class Extensions {
	
	public static java.sql.Date convertUtilToSql(java.util.Date uDate) {
		if (uDate != null)
			return new java.sql.Date(uDate.getTime());			
		return null;
    }
}
