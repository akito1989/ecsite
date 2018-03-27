package example.config;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
//@PropertySource("classpath:jdbc.properties")
@ComponentScan("example.app")
public class WebMvcConfig extends WebMvcConfigurerAdapter{

//	viewResolverをconfigureクラスに設定するとデフォルトでは
//	src/main/webapp/WEB-INF配下のjspファイルを探すようになる。
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry){
		registry.jsp();
	}

	@Bean
	public DriverManagerDataSource dataSource(
			@Value("${jdbc.driverClassName}")String driverClassName,
			@Value("${jdbc.url}")String url,
			@Value("${jdbc.username}")String username,
			@Value("${jdbc.password}")String password
			){

		//なぜか@Valueで値がとれないので直うちしています。
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/shop");
		dataSource.setUsername("root");
		dataSource.setPassword("akitopass");
		return dataSource;
	}

	@Bean
	@Autowired
	@Qualifier("dataSource")
	public JdbcTemplate jdbcTemplate(DriverManagerDataSource dataSource){
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public MultipartResolver multipartResolver(){
		return new StandardServletMultipartResolver();
	}

	@Bean
	public Map<String,String> pullDownYear(){
		Map<String,String> map = new LinkedHashMap<>();

		map.put("2017","2017");
		map.put("2018","2018");
		map.put("2019","2019");
		map.put("2020","2020");

		return Collections.unmodifiableMap(map);
	}

	@Bean
	public Map<String,String> pullDownMonth(){
		Map<String,String> map = new LinkedHashMap<>();

		map.put("01","01");
		map.put("02","02");
		map.put("03","03");
		map.put("04","04");
		map.put("05","05");
		map.put("06","06");
		map.put("07","07");
		map.put("08","08");
		map.put("09","09");
		map.put("10","10");
		map.put("11","11");
		map.put("12","12");

		return Collections.unmodifiableMap(map);
	}

	@Bean
	public Map<String,String> pullDownDay(){
		Map<String,String> map = new LinkedHashMap<>();

		map.put("01","01");
		map.put("02","02");
		map.put("03","03");
		map.put("04","04");
		map.put("05","05");
		map.put("06","06");
		map.put("07","07");
		map.put("08","08");
		map.put("09","09");
		map.put("10","10");
		map.put("11","11");
		map.put("12","12");
		map.put("13","13");
		map.put("14","14");
		map.put("15","15");
		map.put("16","16");
		map.put("17","17");
		map.put("18","18");
		map.put("19","19");
		map.put("20","20");
		map.put("21","21");
		map.put("22","22");
		map.put("23","23");
		map.put("24","24");
		map.put("25","25");
		map.put("26","26");
		map.put("27","27");
		map.put("28","28");
		map.put("29","29");
		map.put("30","30");
		map.put("31","31");

		return Collections.unmodifiableMap(map);
	}

	@Bean
	public Map<String, String> pullBirth(){
		Map<String,String> map = new LinkedHashMap<>();
		map.put("1910","1910年代");
		map.put("1920","1920年代");
		map.put("1930","1930年代");
		map.put("1940","1940年代");
		map.put("1950","1950年代");
		map.put("1960","1960年代");
		map.put("1970","1970年代");
		map.put("1980","1980年代");
		map.put("1990","1990年代");
		map.put("2000","2000年代");
		map.put("2010","2010年代");

		return Collections.unmodifiableMap(map);
	}

}
