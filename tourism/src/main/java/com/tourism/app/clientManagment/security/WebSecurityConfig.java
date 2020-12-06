package com.tourism.app.clientManagment.security;

import com.tourism.app.clientManagment.security.authProviders.AdminAuthenticationProvider;
import com.tourism.app.clientManagment.security.authProviders.GuideAuthenticationProvider;
import com.tourism.app.clientManagment.security.authProviders.TouristAuthenticationProvider;
import com.tourism.app.clientManagment.security.jwt.AuthEntryPointJwt;
import com.tourism.app.clientManagment.security.jwt.AuthTokenFilter;
import com.tourism.app.clientManagment.services.AdminDetailsServiceImpl;
import com.tourism.app.clientManagment.services.GuideDetailsServiceImpl;
import com.tourism.app.clientManagment.services.TouristDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
         securedEnabled = true,
         jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    TouristDetailsServiceImpl touristDetailsService;
    @Autowired
    GuideDetailsServiceImpl guideDetailsService;
    @Autowired
    AdminDetailsServiceImpl adminDetailsService;
    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.authenticationProvider(getTouristAuthenticationProvider());
        authenticationManagerBuilder.authenticationProvider(getGuideAuthenticationProvider());
        authenticationManagerBuilder.authenticationProvider(getAdminAuthenticationProvider());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                //TODO: Modify this Paths
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/test/**").permitAll()
                .antMatchers("/trip-guide/**").permitAll()
                .antMatchers("/trip/**").permitAll()
                .antMatchers("api/one-user/**").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public AdminAuthenticationProvider getAdminAuthenticationProvider() {
        AdminAuthenticationProvider dao = new AdminAuthenticationProvider();
        dao.setUserDetailsService(adminDetailsService);
        dao.setPasswordEncoder(passwordEncoder());
        return dao;
    }
    @Bean
    public TouristAuthenticationProvider getTouristAuthenticationProvider() {
        TouristAuthenticationProvider dao = new TouristAuthenticationProvider();
        dao.setUserDetailsService(touristDetailsService);
        dao.setPasswordEncoder(passwordEncoder());
        return dao;
    }
    @Bean
    public GuideAuthenticationProvider getGuideAuthenticationProvider() {
        GuideAuthenticationProvider dao = new GuideAuthenticationProvider();
        dao.setUserDetailsService(guideDetailsService);
        dao.setPasswordEncoder(passwordEncoder());
        return dao;
    }
}
