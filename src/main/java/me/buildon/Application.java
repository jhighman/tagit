package me.buildon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import me.buildon.domain.Account;
import me.buildon.domain.Persona;
import me.buildon.repo.AccountRepository;
import me.buildon.repo.PersonaRepository;

@SpringBootApplication
public class Application {

    /**
     * @author Jeff Highman
     * 
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    CommandLineRunner init(final AccountRepository accountRepository, final PersonaRepository personaRepository) {
      
      return new CommandLineRunner() {
 
        @Override
        public void run(String... arg0) throws Exception {
        	accountRepository.deleteAll();
          accountRepository.save(new Account("jeff", "jeff"));
          personaRepository.deleteAll();
          Persona spiderman = new Persona("Spiderman");
          spiderman.setPid(1);
          spiderman.addTag("Superhero");
          spiderman.addTag("Generally swell guy");
          personaRepository.save(spiderman);
    
        }
        
      };
 
    }
}


@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {
 
  @Autowired
  AccountRepository accountRepository;
  
  @Autowired
  PersonaRepository personaRepository;
  
 
  @Override
  public void init(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService());
  }
 
  @Bean
  UserDetailsService userDetailsService() {
    return new UserDetailsService() {
 
      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if(account != null) {
        return new User(account.getUsername(), account.getPassword(), true, true, true, true,
                AuthorityUtils.createAuthorityList("USER"));
        } else {
          throw new UsernameNotFoundException("could not find the user '"
                  + username + "'");
        }
      }
      
    };
  }
}
 
@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().anyRequest().fullyAuthenticated().and().
    httpBasic().and().
    csrf().disable();
  }
  
}
