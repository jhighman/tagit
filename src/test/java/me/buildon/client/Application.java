package me.buildon.client;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... strings) throws Exception {
    	RestTemplateFactory factory = new RestTemplateFactory();
        RestTemplate restTemplate = factory.getObject();
        Person quote = restTemplate.getForObject("http://localhost:8080/persona/55d39ebd1033bc175c7f82ba", Person.class);
        System.out.println("Made it:" + quote.toString());
        log.info(quote.toString());
    }
    
    HttpHeaders createHeaders( String username, String password ){
    	   return new HttpHeaders(){
    	      {
    	         String auth = username + ":" + password;
    	         byte[] encodedAuth = Base64.encodeBase64( 
    	            auth.getBytes(Charset.forName("US-ASCII")) );
    	         String authHeader = "Basic " + new String( encodedAuth );
    	         set( "Authorization", authHeader );
    	      }
    	   };
    	}
}
