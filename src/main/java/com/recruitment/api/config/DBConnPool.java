package com.recruitment.api.config;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value= {"classpath:application.yml"})
public class DBConnPool {

	@Autowired
    Environment environment;
	private static BasicDataSource dataSource = new BasicDataSource();
    
    @Bean
    public void datasource() throws PropertyVetoException {
    	dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        try {
			dataSource.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
//    static {
//    
//    	dataSource.setDriverClassName(driverName);
//        dataSource.setUsername(userName);
//        dataSource.setPassword(password);
//        dataSource.setUrl(url);
//        try {
//			dataSource.getConnection().close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }
    
    public static Connection getConnection() throws Exception {
	    Connection conn = dataSource.getConnection();
	    conn.setAutoCommit(false);
	    return conn;
    }

	public static Connection getAutoCommitConnection() throws Exception {
	    Connection conn = dataSource.getConnection();
	    conn.setAutoCommit(true);
	    return conn;
	}

	public void close() throws Exception {
	    dataSource.close();
	};
}
