import apiclients.PetApiClient;
import models.Pet;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetCRUDTest extends BaseApiTest{

    @Test
    public void testReadNonExistingPet() {
        long nonExistingPetId = 4;

        PetApiClient petApiClient = new PetApiClient(requestSpec);
        petApiClient.getPetById(nonExistingPetId)
                .then()
                .body(equalTo("Pet not found"))
                .statusCode(404);

    }

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

        assertEquals(testPetData.getId(), createdPet.getId());
        assertEquals(testPetData.getName(), createdPet.getName());
        assertEquals(testPetData.getStatus(), createdPet.getStatus());
    }

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

        assertEquals("UpdatedName", updatedPet.getName());
        assertEquals(models.Status.sold, updatedPet.getStatus());
    }

    @Test
    public void testDeleteExistingPet() {
        PetApiClient petApiClient = new PetApiClient(requestSpec);
        petApiClient.createPet(testPetData)
                .then()
                .statusCode(200);

        petApiClient.deletePet(testPetData.getId())
                .then()
                .statusCode(200);

        petApiClient.getPetById(testPetData.getId())
                .then()
                .body(equalTo("Pet not found"))
                .statusCode(404);

    }
}
