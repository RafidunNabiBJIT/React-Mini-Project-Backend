package com.mini.project;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini.project.model.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerMockmvcTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testRegisterAndRetrieveUsers() throws Exception {
		UserDto userDto = new UserDto();
		userDto.setId(1L);
		userDto.setAddress("Dhaka");
		userDto.setEmail("shadril@gmail.com");
		userDto.setFirstName("Fahim");
		userDto.setLastName("Rifat");
		userDto.setPassword("123");
		userDto.setRole("CUSTOMER");

		ObjectMapper objectMapper = new ObjectMapper();
		String userDtoJson = objectMapper.writeValueAsString(userDto);

		mockMvc.perform(post("/users/register")
						.contentType(MediaType.APPLICATION_JSON)
						.content(userDtoJson))
				.andExpect(status().is2xxSuccessful());

		mockMvc.perform(get("/users/all"))
				.andExpect(status().isOk());
	}
}
