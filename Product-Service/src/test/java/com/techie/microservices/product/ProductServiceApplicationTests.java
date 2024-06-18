package com.techie.microservices.product;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

import io.restassured.RestAssured;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {
	//creating a mongo db container
	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");
	@LocalServerPort
	private Integer port;
	@BeforeEach
	void setup(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}
	static{
		mongoDBContainer.start();
	}
	@Test
	void shouldCreateProduct() {
		String requestBody = """
				{
				"name": "Samsung Galaxy S21",
				"description": "Samsung Galaxy S21",
				"price": 1000
				}
				""";
		RestAssured.given()
		.contentType("application/json")
		.body(requestBody)
		.when()
		.post("/api/product")
		.then()
		.statusCode(201)
		.body("Id",Matchers.notNullValue())
		.body("name",Matchers.equalTo("Samsung Galaxy S21"))
		.body("description",Matchers.equalTo("Samsung Galaxy S21"))
		.body("price",Matchers.equalTo(1000));
		
	}

}
