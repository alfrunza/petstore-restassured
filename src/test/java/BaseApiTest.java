import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.specification.RequestSpecification;
import models.Pet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.InputStream;

/* Even though BaseTest is not usually located in the test package,
   for this example it is placed here to facilitate access to test resources
   and for clarity in the testing context.
*/

/**
 * Base class for API tests, providing common setup and test data.
 */
public class BaseApiTest {
    protected static Pet testPetData;
    protected RequestSpecification requestSpec;

    /**
     * Initializes test data from a JSON file before all tests.
     *
     * @throws Exception if there is an error reading the test data
     */
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

    /**
     * Sets up the request specification before each test.
     */
    @BeforeEach
    public void setup() {
        requestSpec = io.restassured.RestAssured.given()
                .baseUri(utils.ConfigurationData.getBaseUrl())
                .header("api_key", utils.ConfigurationData.getApiKey())
                .header("Content-Type", "application/json");
    }
}
