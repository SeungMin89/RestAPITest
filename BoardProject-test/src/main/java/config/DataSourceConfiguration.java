package config;

import javax.sql.DataSource; 
      //JDBC 커넥션풀을 사용하기 위해서 필요
	  //db와 연결된 커넥션을 미리 만들어서 풀(pool)속에 저장해 두고 있다가 필요할 때에 커넥션을 풀에서 가져다 쓰고 다시 풀에 반환하는 기법

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;




public class DataSourceConfiguration {
	private static final Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);
	
	public DataSource dataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		String driver = LibUtil.getProperties("spring.datasource.driverclassname");
		String url = LibUtil.getProperties("spring.datasource.url");
		String id = LibUtil.getProperties("spring.datasource.username");
		String password = LibUtil.getProperties("spring.datasource.password");
		datasource.setDriverClassName(driver);
		datasource.setUrl(url);
		datasource.setUsername(id);
		datasource.setPassword(password);
		
		
		return datasource;
		
	}
	
	
	
	
}
