package com.techie.microservices.product;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {
	//creating a mongo db container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");
	@Test
	void shouldCreateProduct() {
		  
	}

}
