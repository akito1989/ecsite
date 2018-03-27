//package example.app.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//@Configuration
//@PropertySource("classpath:jdbc.properties")
//public class PoolingDataSourceConfig {
//	@Bean(destroyMethod="close")
//	public DriverManagerDataSource dataSource(
//			@Value("${jdbc.driverClassName}")String driverClassName,
//			@Value("${jdbc.url}")String url,
//			@Value("${jdbc.username}")String username,
//			@Value("${jdbc.password}")String password
//			){
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
//		dataSource.setUrl(url);
//		dataSource.setUsername(username);
//		dataSource.setPassword(password);
//		return dataSource;
//	}
//}
