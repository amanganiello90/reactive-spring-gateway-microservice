package com.github.amanganiello90.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.amanganiello90.boot.GatewayApplication;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;


@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = { GatewayApplication.class },
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GatewayApplicationTests {
  
  //@LocalServerPort
  int port;
  
  //TestRestTemplate restTemplate = new TestRestTemplate();
  
  HttpHeaders headers = new HttpHeaders();
  
  //@Test
  public void testRetrieveStudentCourse() {
    
    
    
   /* 
    HttpEntity<String> entity = new HttpEntity<String>(null, headers);
    
    ResponseEntity<String> response = restTemplate.exchange(
        createURLWithPort("/"),
        HttpMethod.GET, entity, String.class);
    
    
    
    System.out.println("Header: " + response.getHeaders().toString());*/
   
    
    // String expected = "{id:Course1,name:Spring,description:10 Steps}";
    
    // JSONAssert.assertEquals(expected, response.getBody(), false);
  }
  
  private String createURLWithPort(String uri) {
    return "http://localhost:" + port + uri;
  }
  
}
