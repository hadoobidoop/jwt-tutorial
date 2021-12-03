package com.bambi.tutorial.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/*
@EnableWebSecurity 기본적인 web 보안을 활성화 하겠다는 의미의 어노테이션
추가적인 설정을 위해 WebSecurityConfigurer를 implements하거나
WebSecurityConfigurerAdaper를 extends 하는 방법이 있다!
* */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests() // HttpServletRequest를 사용하는 요청들에 대한 접근 제한을 설정하겠습니다
        .antMatchers("/api/hello").permitAll() ///api/hello에 대한 요청은 인증없이 접근을 허용할게요
        .anyRequest().authenticated(); //나머지 요청은 모두 인증이 필요해요
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring()
        .antMatchers("/h2-console/**", "/favicon.ico");
  }
}
