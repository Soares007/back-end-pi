package fatec.sp.gov.br.sistemaescolarbackend.resources.security;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/api/public/**").permitAll() // Rotas públicas
                .antMatchers("/api/student/**").hasRole("STUDENT") // Permissão para alunos
                .antMatchers("/api/teacher/**").hasRole("TEACHER") // Permissão para professores
                .antMatchers("/api/coordinator/**").hasRole("COORDINATOR") // Permissão para coordenadores
                .and()
            .httpBasic() // Usar autenticação básica
            .and()
            .csrf().disable(); // Desativar CSRF para simplificar o exemplo
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService)
            .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
