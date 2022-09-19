package gestion.burger.burger.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import gestion.burger.burger.service.MyUserDetailsService;


@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
        .passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/login").permitAll()
        .antMatchers("/inscription").permitAll()
        .antMatchers("/index").permitAll()
        .antMatchers("/gestionnaire/**").hasAuthority("ADMIN").anyRequest()
        .authenticated().and().csrf().disable().formLogin()
        .loginPage("/login").failureUrl("/login?error=true")
        .defaultSuccessUrl("/gestionnaire/home")
        .usernameParameter("user_name")
        .passwordParameter("password")
        .and().logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login").and().exceptionHandling()
                .accessDeniedPage("/access-denied");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/stylesheets/**", "/js/**", "/images/**");
    }

    @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }






@Bean
  BCryptPasswordEncoder encoder() { return new BCryptPasswordEncoder(); }



}
