import apiclients.PetApiClient;
import models.Pet;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * CRUD test cases for Pet API operations.
 */
public class PetCRUDTest extends BaseApiTest{

    // Test to read a non-existing pet (to make sure the pet does not exist before CRUD operations)
    @Test
    public void testReadNonExistingPet() {
        long nonExistingPetId = 4;

        PetApiClient petApiClient = new PetApiClient(requestSpec);
        petApiClient.getPetById(nonExistingPetId)
                .then()
                .body(equalTo("Pet not found"))
                .statusCode(404);

    }

    // Test to create a new pet
    @Test
    public void testCreateNewPet() {
        PetApiClient petApiClient = new PetApiClient(requestSpec);
        petApiClient.createPet(testPetData)
                .then()
                .statusCode(200);

        Pet createdPet = petApiClient.getPetById(testPetData.getId())
                .then()
                .statusCode(200)
                .extract()
                .as(Pet.class);

        assertEquals(testPetData.getId(), createdPet.getId(), "Pet ID does not match");
        assertEquals(testPetData.getName(), createdPet.getName(), "Pet name does not match");
        assertEquals(testPetData.getStatus(), createdPet.getStatus(), "Pet status does not match");
    }

    // Test to update the newly added pet
    @Test
    public void testUpdateExistingPet() {
        PetApiClient petApiClient = new PetApiClient(requestSpec);
        petApiClient.createPet(testPetData)
                .then()
                .statusCode(200);

        testPetData.setName("UpdatedName");
        testPetData.setStatus(models.Status.sold);

        petApiClient.updatePet(testPetData)
                .then()
                .statusCode(200);

        Pet updatedPet = petApiClient.getPetById(testPetData.getId())
                .then()
                .statusCode(200)
                .extract()
                .as(Pet.class);

        assertEquals("UpdatedName", updatedPet.getName(), "Pet name was not updated");
        assertEquals(models.Status.sold, updatedPet.getStatus(), "Pet status was not updated");
    }

    // Test to delete the pet
    @Test
    public void testDeleteExistingPet() {
        PetApiClient petApiClient = new PetApiClient(requestSpec);
        petApiClient.createPet(testPetData)
                .then()
                .statusCode(200);

        petApiClient.deletePet(testPetData.getId())
                .then()
                .statusCode(200);

        // Verify the pet has been deleted
        petApiClient.getPetById(testPetData.getId())
                .then()
                .body(equalTo("Pet not found"))
                .statusCode(404);

    }
}
