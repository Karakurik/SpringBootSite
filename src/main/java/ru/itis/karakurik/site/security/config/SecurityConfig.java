package ru.itis.karakurik.site.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ru.itis.karakurik.site.model.user.Role;
import ru.itis.karakurik.site.security.details.CustomUserDetailsService;

import javax.sql.DataSource;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Configuration
    @Order(1)
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Autowired
        @CustomUserDetailsService
        private UserDetailsService userDetailsService;

        @Autowired
        @Qualifier("dataSource")
        private DataSource dataSource;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/signUp/**").permitAll()
                    .antMatchers("/login/**").permitAll()
                    .antMatchers("/resetPassword/**").permitAll()
                    .antMatchers("/changePassword/**").permitAll()
                    .antMatchers("/hello/**").permitAll()
                    .antMatchers("/books/**").permitAll()
                    .antMatchers("/test/**").permitAll()
                    .antMatchers("/showImage/**").permitAll()
                    .antMatchers("/admin/**").hasAuthority(Role.ROLE_ADMIN.name())
                    .antMatchers("/static/**").permitAll()
                    .antMatchers("/templates/exception/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .usernameParameter("email")
                    .defaultSuccessUrl("/books")
                    .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                    .deleteCookies("JSESSION")
                    .invalidateHttpSession(true)
                    .and().rememberMe()
                    .rememberMeParameter("remember-me").tokenRepository(persistentTokenRepository())
                    .and()
                    .csrf().disable();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        }

        @Bean
        public PersistentTokenRepository persistentTokenRepository() {
            JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
            jdbcTokenRepository.setDataSource(dataSource);
            return jdbcTokenRepository;
        }
    }

    @Configuration
    @Order(2)
    static class OAuth2SecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests()
//                    .antMatchers("/", "/login", "/oauth/**").permitAll()
//                    .anyRequest().authenticated()
//                    .and()
//                    .formLogin().permitAll()
//                    .and()
//                    .oauth2Login()
//                    .loginPage("/oauth/login")
//                    .userInfoEndpoint()
//                    .userService(oauthUserService);
//        }
//
//        @Autowired
//        private CustomOAuth2UserService oauthUserService;
    }
}
