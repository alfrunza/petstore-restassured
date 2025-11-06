package apiclients;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Pet;

public class PetApiClient {
    private RequestSpecification requestSpec;

    public PetApiClient(RequestSpecification requestSpec) {
        this.requestSpec = requestSpec;
    }

    public Response createPet(Pet petPayload) {
        return requestSpec
                .body(petPayload)
                .when()
                .post("/pet");
    }

    public Response getPetById(long petId) {
        return requestSpec
                .when()
                .get("/pet/" + petId);
    }

    public Response updatePet(Pet petPayload) {
        return requestSpec
                .body(petPayload)
                .when()
                .put("/pet");
    }

    public Response deletePet(long petId) {
        return requestSpec
                .when()
                .delete("/pet/" + petId);
    }
}
