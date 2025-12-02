package apollo.exercise;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class VehicleController422Test {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void whenPriceHasMoreThanTwoDecimalPlaces() throws Exception {
		String payload = """
				{
				    "manufacturerName": "Tesla",
				    "description": "Electric beast",
				    "horsePower": 900,
				    "modelName": "Model S",
				    "modelYear": 2025,
				    "price": 99999.999,
				    "fuelType": "ELECTRIC",
				    "vinNumber": "5YJSA1E27HF123456"
				}
				""";

		mockMvc.perform(post("/vehicle").contentType(MediaType.APPLICATION_JSON).content(payload))
				.andExpect(content().string("Unprocessable Entity"));
	}

	@Test
	void price_Null() throws Exception {
		String payload = """
				{
				    "manufacturerName": "Tesla",
				    "description": "Electric beast",
				    "horsePower": 900,
				    "modelName": "Model S",
				    "modelYear": 2025,
				    "price": null,
				    "fuelType": "ELECTRIC",
				    "vinNumber": "5YJSA1E27HF123456"
				}
				""";

		mockMvc.perform(post("/vehicle").contentType(MediaType.APPLICATION_JSON).content(payload))
				.andExpect(content().string("Unprocessable Entity"));
	}

	@Test
	void price_Negative() throws Exception {
		String payload = """
				{
				    "manufacturerName": "Tesla",
				    "description": "Electric beast",
				    "horsePower": 900,
				    "modelName": "Model S",
				    "modelYear": 2025,
				    "price": -1,
				    "fuelType": "ELECTRIC",
				    "vinNumber": "5YJSA1E27HF123456"
				}
				""";

		mockMvc.perform(post("/vehicle").contentType(MediaType.APPLICATION_JSON).content(payload))
				.andExpect(content().string("Unprocessable Entity"));
	}

	@Test
	void horsePower_null() throws Exception {
		String payload = """
				{
				    "manufacturerName": "Tesla",
				    "description": "Electric beast",
				    "horsePower": null,
				    "modelName": "Model S",
				    "modelYear": 2025,
				    "price": 100,
				    "fuelType": "ELECTRIC",
				    "vinNumber": "5YJSA1E27HF123456"
				}
				""";

		mockMvc.perform(post("/vehicle").contentType(MediaType.APPLICATION_JSON).content(payload))
				.andExpect(content().string("Unprocessable Entity"));
	}

	@Test
	void horsePower_ZeroOrNegative() throws Exception {
		String payload = """
				{
				    "manufacturerName": "Tesla",
				    "description": "Electric beast",
				    "horsePower": -50,
				    "modelName": "Model S",
				    "modelYear": 2025,
				    "price": 100,
				    "fuelType": "ELECTRIC",
				    "vinNumber": "5YJSA1E27HF123456"
				}
				""";

		mockMvc.perform(post("/vehicle").contentType(MediaType.APPLICATION_JSON).content(payload))
				.andExpect(content().string("Unprocessable Entity"));
	}

	@Test
	void vinNumber_TooShort() throws Exception {
		String payload = """
				{
				    "manufacturerName": "Tesla",
				    "description": "Electric beast",
				    "horsePower": 100,
				    "modelName": "Model S",
				    "modelYear": 2025,
				    "price": 100,
				    "fuelType": "ELECTRIC",
				    "vinNumber": "5YJSA1E27HF12345"
				}
				""";

		mockMvc.perform(post("/vehicle").contentType(MediaType.APPLICATION_JSON).content(payload))
				.andExpect(content().string("Unprocessable Entity"));
	}

	@Test
	void vinNumber_TooLong() throws Exception {
		String payload = """
				{
				    "manufacturerName": "Tesla",
				    "description": "Electric beast",
				    "horsePower": 100,
				    "modelName": "Model S",
				    "modelYear": 2025,
				    "price": 100,
				    "fuelType": "ELECTRIC",
				    "vinNumber": "5YJSA1E27HF1234567"
				}
				""";

		mockMvc.perform(post("/vehicle").contentType(MediaType.APPLICATION_JSON).content(payload))
				.andExpect(content().string("Unprocessable Entity"));
	}

	@Test
	void vinNumber_ContainsForbiddenChars() throws Exception {
		String payload = """
				{
				    "manufacturerName": "Tesla",
				    "description": "Electric beast",
				    "horsePower": 100,
				    "modelName": "Model S",
				    "modelYear": 2025,
				    "price": 100,
				    "fuelType": "ELECTRIC",
				    "vinNumber": "5YJSA1E2IHF123456"
				}
				""";

		mockMvc.perform(post("/vehicle").contentType(MediaType.APPLICATION_JSON).content(payload))
				.andExpect(content().string("Unprocessable Entity"));
	}

	@Test
	void manufacturerName_Missing() throws Exception {
		String payload = """
				{
				    "manufacturerName": "",
				    "description": "Electric beast",
				    "horsePower": 100,
				    "modelName": "Model S",
				    "modelYear": 2025,
				    "price": 100,
				    "fuelType": "ELECTRIC",
				    "vinNumber": "5YJSA1E27HF123456"
				}
				""";

		mockMvc.perform(post("/vehicle").contentType(MediaType.APPLICATION_JSON).content(payload))
				.andExpect(content().string("Unprocessable Entity"));
	}

	@Test
	void allRequiredFieldsMissing() throws Exception {
		mockMvc.perform(post("/vehicle").contentType(MediaType.APPLICATION_JSON).content("{}"))
				.andExpect(content().string("Unprocessable Entity"));
	}

}