package io.github.mattheusffalbuquerque.duma.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/actuator/**").permitAll()
                .requestMatchers("/swagger/**", "/swagger-ui/**", "/api-docs/**").permitAll()
                .anyRequest().authenticated() // ← troque quando implementar JWT
            )
            .oauth2ResourceServer(oauth2 -> oauth2
                .jwt(jwt -> {})
            );
        return http.build();
    }

    /*
    * PasswordEncoder and AuthenticationManager beans
    * were removed because they are not needed when using 
    * Keycloak as the authentication provider. 
    * Spring Security will delegate authentication to Keycloak, 
    * so we don't need to manage user credentials or authentication logic in our application.
    */ 

}
