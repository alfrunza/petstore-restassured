import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.specification.RequestSpecification;
import models.Pet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.InputStream;

public class BaseApiTest {
    protected static Pet testPetData;
    protected RequestSpecification requestSpec;

    @BeforeAll
    public static void initTestData() throws Exception {
        try (InputStream is = BaseApiTest.class.getClassLoader().getResourceAsStream("testData.json")) {
            if (is == null) {
                throw new IllegalStateException("testData.json file not found");
            }

            ObjectMapper objectMapper = new ObjectMapper();
            testPetData = objectMapper.readValue(is, Pet.class);
        }
    }

    @BeforeEach
    public void setup() {
        requestSpec = io.restassured.RestAssured.given()
                .baseUri(utils.ConfigurationData.getBaseUrl())
                .header("api_key", utils.ConfigurationData.getApiKey())
                .header("Content-Type", "application/json");
    }
}
