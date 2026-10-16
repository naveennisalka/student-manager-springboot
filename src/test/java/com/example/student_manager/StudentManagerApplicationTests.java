package com.example.student_manager;

import java.net.HttpURLConnection;
import java.net.URI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentManagerApplicationTests {

	@Value("${local.server.port}")
	private int port;

	@Test
	void contextLoads() {
	}

	@Test
	void h2ConsoleIsAvailableAtConfiguredPath() throws Exception {
		HttpURLConnection connection = (HttpURLConnection) URI.create(
				"http://localhost:" + port + "/h2-console/").toURL().openConnection();
		connection.setRequestMethod("GET");

		Assertions.assertEquals(HttpURLConnection.HTTP_OK, connection.getResponseCode());
		connection.disconnect();
	}

}
