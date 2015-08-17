package me.buildon;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;


public class TestRestService extends BaseWebApplicationContextTests {

    
    @Test
    public void testGetSkillTagAsXML() throws Exception {
        request.setMethod("GET");
        request.addHeader("Accept", "application/xml");
        request.addHeader("Content-Type", "application/xml");
        request.setRequestURI("/skillTag/1");
        request.setContentType("application/xml");
        request.setMethod("GET");

        servlet.service(request, response);
    
        String result = response.getContentAsString(); String resuestString = request.getRequestURI();
        
        System.out.println("Input: " + resuestString);
        System.out.println("Output: " + result);
        
        
        Assert.assertEquals(200, response.getStatus());
        String expectedXML = "<skillTag><id>1</id><person>Rama</person><tag>Ops</tag></skillTag>";
        Assert.assertEquals(expectedXML, result);
    }
    
    
    
    @Test
    public void testSkillTagAsJSon() throws Exception {
        request.setMethod("GET");
        request.addHeader("Accept", "application/json");
        request.addHeader("Content-Type", "application/xml");
        request.setRequestURI("/skillTag/1");
        request.setContentType("application/xml");
        request.setMethod("GET");

        servlet.service(request, response);
        String resuestString = request.getRequestURI();
  
        String result = response.getContentAsString();
        System.out.println("Input: " + resuestString);
        System.out.println("Output: " + result);
        Assert.assertEquals(200, response.getStatus());
        String expectedJSON = "{\"person\":\"Rama\",\"tag\":\"Ops\",\"id\":1}";
        Assert.assertEquals(createTree(expectedJSON), createTree(result));
    }


    private JsonNode createTree(String jsonString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString, JsonNode.class);
    }

    @Test
    public void testAddSkillTagUsingXML() throws Exception {
        request.setMethod("POST");
        request.addHeader("Accept", "application/xml");
        request.setContentType("application/xml");
        request.setRequestURI("/skillTag/add");
        request.addHeader("Content-Type", "application/xml");
        request.setContent("<skillTag><id>-1</id><person>William Smith</person><tag>Advanced Java</tag></skillTag>".getBytes("utf-8"));
        servlet.service(request, response);
        String result = response.getContentAsString();
        int status = response.getStatus();
        Assert.assertEquals(201, status);
        long expectedId=skillTagService.getSkillTagCount()-1;
        String expectedXML = "<object><id>"+expectedId+"</id></object>";
        Assert.assertEquals(expectedXML, result);
    }

    
    
    @Test
    public void testAddSkillTagUsingJSON() throws Exception {
        request.setMethod("POST");
        request.addHeader("Accept", "application/json");
        request.setContentType("application/json;charset=UTF-8");
        request.setRequestURI("/skillTag/add");
        request.addHeader("Content-Type", "application/json;charset=UTF-8");
        request.setContent("{\"person\":\"Bill\",\"tag\":\"Underwater Basket Weaving\",\"id\":-1}".getBytes("utf-8"));
        servlet.service(request, response);
        String result = response.getContentAsString();
        int status = response.getStatus();
        Assert.assertEquals(201, status);
        // count starts at zero
        long expectedId=skillTagService.getSkillTagCount()-1;
        String expectedJSON = "{\"id\":"+expectedId+"}";
        Assert.assertEquals(createTree(expectedJSON), createTree(result));
    }

}
