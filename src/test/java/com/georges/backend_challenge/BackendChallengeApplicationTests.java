package com.georges.backend_challenge;

import com.georges.backend_challenge.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BackendChallengeApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoSuccess() {
		var todo = new Todo("todo1", "desc1", false, "baixa");
		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isCreated()
				.expectBody()
				.jsonPath("name").isEqualTo(todo.getName())
				.jsonPath("description").isEqualTo(todo.getDescription())
				.jsonPath("completed").isEqualTo(todo.getCompleted())
				.jsonPath("priority").isEqualTo(todo.getPriority());

	}

	@Test
	void testCreateTodoFailure() {
		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(new Todo("","",false, "none"))
				.exchange()
				.expectStatus().isEqualTo(500);
	}

}
