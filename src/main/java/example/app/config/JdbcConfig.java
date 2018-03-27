//package example.app.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//@Configuration
//public class JdbcConfig {
//
//	@Bean
//	@Autowired
//	@Qualifier("dataSource")
//	public JdbcTemplate jdbcTemplate(DriverManagerDataSource dataSource){
//		return new JdbcTemplate(dataSource);
//	}
//}
