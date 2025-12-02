package apollo.exercise;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class VehicleController400Test {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void missingComma() throws Exception {
		String payload = """
				{
				    "manufacturerName": "Tesla"
				    "description": "Electric beast",
				    "horsePower": 900,
				    "modelName": "Model S",
				    "modelYear": 2025,
				    "price": 99999.99,
				    "fuelType": "ELECTRIC",
				    "vinNumber": "5YJSA1E27HF123456"
				}
				""";
		mockMvc.perform(post("/vehicle").contentType(MediaType.APPLICATION_JSON).content(payload))
				.andExpect(status().isBadRequest());
	}

	@Test
	void whenHorsePowerIsSentAsString() throws Exception {
		String payload = """
				{
				    "manufacturerName": "Tesla",
				    "description": "Electric beast",
				    "horsePower": "\\"900\\"",
				    "modelName": "Model S",
				    "modelYear": 2025,
				    "price": 99999.99,
				    "fuelType": "ELECTRIC",
				    "vinNumber": "5YJSA1E27HF123456"
				}
				""";

		mockMvc.perform(post("/vehicle").contentType(MediaType.APPLICATION_JSON).content(payload))
				.andExpect(status().isBadRequest()).andExpect(jsonPath("$.error").value("BAD_REQUEST"));
	}

	@Test
	void price_TrailingDot() throws Exception {
		String payload = """
				{
				    "manufacturerName": "Tesla",
				    "description": "Electric beast",
				    "horsePower": 900,
				    "modelName": "Model S",
				    "modelYear": 2025,
				    "price": 99999.99.,
				    "fuelType": "ELECTRIC",
				    "vinNumber": "5YJSA1E27HF123456"
				}
				""";
		mockMvc.perform(post("/vehicle").contentType(MediaType.APPLICATION_JSON).content(payload))
				.andExpect(status().isBadRequest());
	}

	@Test
	void modelYear_AsString() throws Exception {
		String payload = """
				{
				    "manufacturerName": "Tesla",
				    "description": "Electric beast",
				    "horsePower": 900,
				    "modelName": "Model S",
				    "modelYear": "\\"2025\\"",
				    "price": 99999.99,
				    "fuelType": "ELECTRIC",
				    "vinNumber": "5YJSA1E27HF123456"
				}
				""";
		mockMvc.perform(post("/vehicle").contentType(MediaType.APPLICATION_JSON).content(payload))
				.andExpect(status().isBadRequest());
	}

	@Test
	void completelyBrokenJson() throws Exception {
		mockMvc.perform(post("/vehicle").contentType(MediaType.APPLICATION_JSON).content("this is not json at all {"))
				.andExpect(status().isBadRequest());
	}

}