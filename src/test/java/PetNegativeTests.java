import apiclients.PetApiClient;
import models.Pet;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

/*
 * Negative test cases for Pet API operations.
 */
public class PetNegativeTests extends BaseApiTest{

    // Test to read a non-existing pet
    @Test
    public void testReadNonExistingPet() {
        long nonExistingPetId = 999999;

        PetApiClient petApiClient = new PetApiClient(requestSpec);
        petApiClient.getPetById(nonExistingPetId)
                .then()
                .body(equalTo("Pet not found"))
                .statusCode(404);

    }

    // Test to delete a non-existing pet
    @Test
    public void testDeleteNonExistingPet() {
        long nonExistingPetId = 999999;

        PetApiClient petApiClient = new PetApiClient(requestSpec);
        petApiClient.deletePet(nonExistingPetId)
                .then()
                .body(equalTo("Pet not found"))
                .statusCode(404);
    }

    // Test to create a pet with invalid data
    @Test
    public void testCreatePetWithInvalidData() {
        PetApiClient petApiClient = new PetApiClient(requestSpec);
        // Creating a pet with invalid data (e.g., missing name)
        Pet invalidPetData = new Pet();
        invalidPetData.setId(123456);
        invalidPetData.setStatus(models.Status.available);

        petApiClient.createPet(invalidPetData)
                .then()
                .body(equalTo("Invalid input"))
                .statusCode(400);
    }

    // Test to update a non-existing pet
    @Test
    public void testUpdateNonExistingPet() {
        PetApiClient petApiClient = new PetApiClient(requestSpec);
        // Attempting to update a non-existing pet
        Pet nonExistingPetData = new Pet();
        nonExistingPetData.setId(999999);
        nonExistingPetData.setName("NonExistingPet");
        nonExistingPetData.setStatus(models.Status.available);

        petApiClient.updatePet(nonExistingPetData)
                .then()
                .body(equalTo("Pet not found"))
                .statusCode(404);
    }
}
