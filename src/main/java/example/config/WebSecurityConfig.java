package example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
@ComponentScan
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//	UserDetailsService userDetailsService = new AccountUserDetailsService();

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService)//userDetailServiceを使うとDaoAuthenticProviderが生成される
		.passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(WebSecurity web){
		web.ignoring().antMatchers("/resources/**");
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new  BCryptPasswordEncoder();
	}

//	↓を行う事でpringが提供するログインフォーム機能を立ち上げるリソースを指定できる。
//	(ここではコンテキストパス/staff/*（web.xmlのspringSecurityFilterChain
//	 のfilterで指定）で表現されるリソース（staff一覧など）にアクセスがあった場合、
//	 \/staff\/loginで呼び出される（staffController経由）staff_login.jspを
//	 sprignSecurity機能を搭載したログインフォームとして指定し、これを呼び出す様にしている）
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.formLogin()
		.loginPage("/staff/login")
		.defaultSuccessUrl("/staff/top")
		.permitAll();

		http
		.logout()
		.logoutUrl("/staff/logout")
		.logoutSuccessUrl("/staff/logoutSuccess")
		.permitAll();

		http.authorizeRequests().
		anyRequest().
		authenticated();

	}
}
