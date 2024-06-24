package aw.modulo6.configuration;

import aw.modulo6.service.Impl.UsuarioServiceImpl;
import aw.modulo6.service.UsuarioService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Log4j2
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        try {
            auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.info("ERROR configureGlobal",e);
        }
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/", "/login").permitAll()
                        .anyRequest().authenticated()
                ).formLogin((form) -> form
                        .loginPage("/login")
                        .usernameParameter("username").passwordParameter("password")
                        .defaultSuccessUrl("/menu", true)
                        .failureUrl("/login?error=true")
                ).logout((logout) -> logout
                        .clearAuthentication(true)
                        .invalidateHttpSession(true)
                        .permitAll()
                ).csrf(AbstractHttpConfigurer::disable
                ).headers(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
