import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz
                .requestMatchers("/", "/index", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin().disable() // disable default login page
            .httpBasic().disable(); // optionally disable basic auth

        return http.build();
    }
}
