package config;

import javax.activation.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@PropertySource("classpath:/application.peroperties")

public class datasourcehikari {
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();

	}

	@Bean
	public DataSource dataSource() {
			DataSource dataSource = new HikariDataSource(hikariConfig());
			log.info("datasource : {}", dataSource);
			return dataSource;
	}
	
	
}
