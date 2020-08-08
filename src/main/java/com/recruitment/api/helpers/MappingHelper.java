package com.recruitment.api.helpers;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class MappingHelper {

	public static Map<String, Object> MappingResultSetToObject(ResultSet resultSet) throws SQLException {
		
		ResultSetMetaData rsmd = resultSet.getMetaData();
		int columnsCount = rsmd.getColumnCount();
		Map<String, Object> params = new HashMap<String, Object>();
		for (int i = 1; i < columnsCount + 1; i++) {

			String cl = rsmd.getColumnName(i).toLowerCase();
			int sqlType = rsmd.getColumnType(i);

			if (resultSet.getObject(i) != null) {
				switch (sqlType) {
				case Types.BIGINT:
				case Types.INTEGER:
				case Types.TINYINT:
				case Types.SMALLINT:

					params.put(cl, resultSet.getInt(i));

					break;
				case Types.DATE:

					params.put(cl, resultSet.getDate(i));

					break;
				case Types.TIMESTAMP:
					params.put(cl, resultSet.getTimestamp(i).getTime());

					break;
				case Types.DOUBLE:
					params.put(cl, resultSet.getDouble(i));

					break;
				case Types.FLOAT:
					params.put(cl, resultSet.getFloat(i));

					break;
				case Types.NVARCHAR:
					params.put(cl, resultSet.getString(i).trim());
					break;
				case Types.VARCHAR:
					params.put(cl, resultSet.getString(i).trim());

					break;
				case Types.BLOB:
					params.put(cl, resultSet.getBlob(i));

					break;
				case Types.CLOB:
					params.put(cl, resultSet.getClob(i));

					break;
				case Types.NCLOB:
					params.put(cl, resultSet.getNClob(i));
					break;
				default:
					params.put(cl, resultSet.getString(i));

					break;
				}
			} else {

				params.put(cl, null);
			}

		}
		
		return params;
	}
}
