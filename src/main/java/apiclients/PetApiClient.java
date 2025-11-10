package apiclients;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Pet;

/**
 * API client for interacting with the Pet API.
 */
public class PetApiClient {
    private RequestSpecification requestSpec;

    // Constructor to initialize the API client with a request specification
    public PetApiClient(RequestSpecification requestSpec) {
        this.requestSpec = requestSpec;
    }

    /** Method to create a new pet
     *
     * @param petPayload The pet object to be created
     * @return The response from the API
     */
    public Response createPet(Pet petPayload) {
        return requestSpec
                .body(petPayload)
                .when()
                .post("/pet");
    }

    /** Method to get a pet by its ID
     *
     * @param petId The ID of the pet to be retrieved
     * @return The response from the API
     */
    public Response getPetById(long petId) {
        return requestSpec
                .when()
                .get("/pet/" + petId);
    }

    /** Method to update an existing pet
     *
     * @param petPayload The pet object with updated information
     * @return The response from the API
     */
    public Response updatePet(Pet petPayload) {
        return requestSpec
                .body(petPayload)
                .when()
                .put("/pet");
    }

    /** Method to delete a pet by its ID
     *
     * @param petId The ID of the pet to be deleted
     * @return The response from the API
     */
    public Response deletePet(long petId) {
        return requestSpec
                .when()
                .delete("/pet/" + petId);
    }
}
