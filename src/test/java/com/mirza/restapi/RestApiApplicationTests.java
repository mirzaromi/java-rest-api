package com.mirza.restapi;

import com.mirza.restapi.dto.request.TodoDtoRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class RestApiApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test
	void getAllTodo(){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<TodoDtoRequest>> todoDtoList = restTemplate.exchange(
				"http://localhost:8080/todo/get",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<>() {}
		);

		System.out.println(todoDtoList);
	}

}
