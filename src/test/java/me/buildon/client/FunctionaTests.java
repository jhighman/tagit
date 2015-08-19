package me.buildon.client;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import me.buildon.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class FunctionaTests {

    @Autowired
    private RestTemplate secureRestTemplate;
    
	@Test
	public void test() {
        
		
        Person quote = secureRestTemplate.getForObject("http://localhost:8080/persona/55d3ce238439cfaa984ef08f", Person.class);
        System.out.println("Made it:" + quote.toString());
        //log.info(quote.toString());
	}

}
