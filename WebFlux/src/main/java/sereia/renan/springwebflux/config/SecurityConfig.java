package sereia.renan.springwebflux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import sereia.renan.springwebflux.service.DevUserService;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
        return http
                .csrf().disable()
                .authorizeExchange()
                .pathMatchers(HttpMethod.POST,"/animes/**").hasAnyRole("ADMIN")
                .pathMatchers(HttpMethod.GET,"/animes/**").hasAnyRole("USER")
                .pathMatchers(HttpMethod.DELETE,"/animes/**").hasAnyRole("ADMIN")
                .pathMatchers(HttpMethod.PUT,"/animes/**").hasAnyRole("ADMIN")
                .pathMatchers("/webjars/**","/v3/api-docs/**","swagger-ui/index.html").permitAll()
                .anyExchange().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and().build();
    }

//    @Bean
//    public MapReactiveUserDetailsService userDetailsService(){
//
//            PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//        UserDetails user = User.withUsername("user").password(passwordEncoder.encode("devrenan"))
//                .roles("USER")
//                .build();
//        UserDetails admin = User.withUsername("admin").password(passwordEncoder.encode("devrenan"))
//                .roles("ADMIN", "USER")
//                .build();
//
//        return new MapReactiveUserDetailsService(admin,user);
//    }

    @Bean
    ReactiveAuthenticationManager reactiveAuthenticationManager(DevUserService service){
        return new UserDetailsRepositoryReactiveAuthenticationManager(service);
    }
}
